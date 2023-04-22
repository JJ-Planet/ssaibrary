package com.jjplanet.ssaibrary.api.member.handler;

import com.jjplanet.ssaibrary.api.member.domain.Member;
import com.jjplanet.ssaibrary.api.member.dto.KakaoDTO;
import com.jjplanet.ssaibrary.api.member.model.JwtCode;
import com.jjplanet.ssaibrary.api.member.model.Role;
import com.jjplanet.ssaibrary.api.member.model.Token;
import com.jjplanet.ssaibrary.api.member.model.TokenKey;
import com.jjplanet.ssaibrary.api.member.provider.TokenProvider;
import com.jjplanet.ssaibrary.api.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.common.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private final MemberRepository memberRepository;
	private final TokenProvider tokenProvider;
//	private final UserClient userClient;

	// 로그인 성공 후 리다이렉트할 프론트 페이지 URL
	private String redirectUrl = "https://ssaibrary.com/signin";

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
										Authentication authentication) throws IOException {

		// OAuth2User 객체를 사용하여 로그인한 사용자의 정보를 가져옴
		OAuth2User oAuth2User = (OAuth2User)authentication.getPrincipal();
		Map<String, Object> attributes = oAuth2User.getAttributes();

		Map<String, Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");
		Map<String, Object> kakaoProfile = (Map<String, Object>)kakaoAccount.get("profile");

		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		Member kakaoMember = new Member((String)kakaoProfile.get("nickname"), currentTimestamp, String.valueOf(attributes.get("id")));
//		KakaoDTO kakaoDTO = KakaoDTO.builder()
//				.nickname((String)kakaoProfile.get("nickname"))
//				.joinDate(currentTimestamp)
//				.kakaoId(String.valueOf(attributes.get("id"))).build();

		log.debug("OAuth2SuccessHandler인데 카카오에서 보내준 사용자 정보로 Member 객체 만들어봤지롱 : {}", kakaoMember);

//		UserDto userDto;

		Member guest = new Member();

		Token tokens = new Token();

		// 회원 정보 받아옴
		Member auth = memberRepository.findByKakaoId(kakaoMember.getKakaoId()).orElse(guest);

		// 최초 로그인이라면 회원가입 처리
		if (auth.equals(guest)) {

			log.debug("카카오 최초 로그인이야");
//			Member kakaoMember = new Member(kakaoDTO.getNickname(), currentTimestamp, kakaoDTO.getKakaoId());
			// 회원 정보 저장
			memberRepository.save(kakaoMember);

			// 저장된 회원 정보 불러옴
			auth = memberRepository.findByKakaoId(kakaoMember.getKakaoId()).orElseThrow(NotFoundException::new);

			log.debug("카카오 최초 로그인 정보 DB에 저장 후 DB에서 다시 불러와봄 : {}", auth);
//			userDto = new UserDto(
//				String.valueOf(auth.getAuthId())
//				, String.valueOf(attributes.get("image"))
//			);

			// token 발행
			tokens = tokenProvider.generateToken(kakaoMember.getId(), Role.USER.getKey());

			log.debug("카카오 최초 로그인 회원 토큰 발행했어 : {}", tokens);

			// refresh token 캐시에 저장
//			tokenProvider.setSaveRefresh(
//				String.valueOf(auth.getId())
//				, tokens.getRefreshToken()
//				, tokenProvider.getExpiration(TokenKey.REFRESH)
//			);

			// 사용자 DB에 저장
			auth.saveRefreshToken(tokens.getRefreshToken());
			memberRepository.saveAndFlush(auth);

//			userClient.insertUser(userDto);
		} else {
//			// 회원가입이 되어있다면 회원 정보를 userDto로 변환
//			userDto = new UserDto(
//				String.valueOf(auth.getAuthId()),
//				String.valueOf(attributes.get("image"))
//			);
			log.debug("카카오로 로그인 한 적 있어");

			String access = tokenProvider.generateAccess(auth.getId(), Role.USER.getKey());
			String refresh = auth.getRefreshToken();


			log.debug("그럼 토큰 확인해볼까? access : {}, refresh : {}", access, refresh);

			if (refresh != null && tokenProvider.validateToken(refresh) == JwtCode.ACCESS) {
				// refresh token이 유효하면 그대로 사용
				log.debug("refresh 토큰 유효해서 그대로 사용할거야");
				tokens = tokens.builder().accessToken(access)
					.refreshToken(refresh).build();
			} else {
				// refresh token이 유효하지 않으면 재발행
				tokens = tokenProvider.generateToken(auth.getId(), Role.USER.getKey());
				log.debug("refresh 유효하지 않아서 재발행했어 {}", tokens);
			}
		}

		String targetUrl = UriComponentsBuilder.fromUriString(redirectUrl)
			.queryParam(TokenKey.ACCESS.getKey(), "Bearer-" + tokens.getAccessToken())
			.queryParam(TokenKey.REFRESH.getKey(), "Bearer-" + tokens.getRefreshToken())
			.build().toUriString();

		// 프론트 페이지로 리다이렉트
		getRedirectStrategy().sendRedirect(request, response, targetUrl);
	}
}