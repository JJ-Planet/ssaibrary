package com.jjplanet.ssaibrary.api.member.filter;

import com.jjplanet.ssaibrary.api.member.domain.Member;
import com.jjplanet.ssaibrary.api.member.dto.KakaoDTO;
import com.jjplanet.ssaibrary.api.member.model.JwtCode;
import com.jjplanet.ssaibrary.api.member.model.Role;
import com.jjplanet.ssaibrary.api.member.model.Token;
import com.jjplanet.ssaibrary.api.member.model.TokenKey;
import com.jjplanet.ssaibrary.api.member.provider.TokenProvider;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjplanet.ssaibrary.api.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.common.exception.NotFoundException;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends GenericFilterBean {

	private final TokenProvider tokenProvider;
	private final MemberRepository memberRepository;


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
			IOException,
			ServletException {

		// HTTP 요청 Header에서 token을 추출하여 반환
		String token = tokenProvider.resolveToken(((HttpServletRequest)request).getHeader(TokenKey.ACCESS.getKey()));


		if (token != null && tokenProvider.validateToken(token) == JwtCode.ACCESS) {
			// 추출된 토큰을 통해 사용자 인증 정보를 읽어 AuthDto 객체에 저장
			String authId = tokenProvider.getUid(token);
			Member member = memberRepository.findById(authId).orElseThrow(NotFoundException::new);
//			AuthDto authDto = AuthDto.builder()
//				.authId(authId)
//				.build();

			// 생성한 AuthDto 객체를 기반으로 Authentication 객체를 생성하여 SecurityContextHolder에 저장
			Authentication auth = getAuthentication(member);
			SecurityContextHolder.getContext().setAuthentication(auth);
			log.info("set Authentication to security context for '{}', uri = {}", auth.getName(),
				((HttpServletRequest)request).getRequestURI());
		} else if (token != null && tokenProvider.validateToken(token) == JwtCode.EXPIRED) {
			// access token이 유효하지 않고, EXPIRED인 경우

			Claims claims = tokenProvider.getClaims(token);
			log.debug("JwtAuthFilter class인데 access token이 만료됐는데 token 확인해보자 {}", claims);
			Member member = memberRepository.findById(claims.getId()).orElseThrow(NotFoundException::new);
//			AuthDto authDto = AuthDto.builder()
//				.authId(claims.getSubject())
//				.build();

			// Header에 존재하는 refresh token
			String refresh = tokenProvider.resolveToken(
				((HttpServletRequest)request).getHeader(TokenKey.REFRESH.getKey()));

			// 캐시에 존재하는 refresh token
			String savedRefresh = tokenProvider.getSavedRefresh(member.getId());

			// refresh token을 확인해서 재발급
			if (token != null && refresh.equals(savedRefresh)
				&& tokenProvider.validateToken(refresh) == JwtCode.ACCESS) {
				Token tokens = tokenProvider.generateToken(member.getId(), Role.USER.getKey());

				tokenProvider.setSaveRefresh(member.getId(),
					tokens.getRefreshToken(), tokenProvider.getExpiration(TokenKey.REFRESH));

				((HttpServletResponse)response).setHeader(TokenKey.ACCESS.getKey(),
					"Bearer " + tokens.getAccessToken());
				((HttpServletResponse)response).setHeader(TokenKey.REFRESH.getKey(),
					"Bearer " + tokens.getRefreshToken());

				Authentication auth = getAuthentication(member);
				SecurityContextHolder.getContext().setAuthentication(auth);
				log.info("set Authentication to security context for '{}', uri = {}", auth.getName(),
					((HttpServletRequest)request).getRequestURI());
			}
		} else {
			log.info("no valid JWT token found, uri: {}", ((HttpServletRequest)request).getRequestURI());
		}
		chain.doFilter(request, response);
	}

	/**
	 * 사용자 인증 정보를 기반으로 Authentication 객체 생성
	 * @param auth
	 * @return
	 */
	public Authentication getAuthentication(Member auth) {
		return new UsernamePasswordAuthenticationToken(auth, "",
			Arrays.asList(new SimpleGrantedAuthority(Role.USER.getKey())));
	}
}