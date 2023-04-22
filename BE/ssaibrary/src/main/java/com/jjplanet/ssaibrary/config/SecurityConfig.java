package com.jjplanet.ssaibrary.config;


import com.jjplanet.ssaibrary.api.member.filter.JwtAuthFilter;
import com.jjplanet.ssaibrary.api.member.handler.OAuth2SuccessHandler;
import com.jjplanet.ssaibrary.api.member.provider.TokenProvider;
import com.jjplanet.ssaibrary.api.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.api.member.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CorsFilter corsFilter;
    private final CustomOAuth2UserService oAuth2UserService;
    private final OAuth2SuccessHandler successHandler;
    private final TokenProvider tokenProvider;
    private final MemberRepository memberRepository;
//    private final AuthTokenProvider tokenProvider;
//    private final TokenAccessDeniedHandler tokenAccessDeniedHandler;

    @Bean
    public WebSecurityCustomizer configure() {
        return web -> web.ignoring().mvcMatchers(
                "/v3/api-docs/**",
                "/swagger-ui/**",
                "/swagger-resources/**",
                "/swagger/**",
                "/webjars/**'",
                "/api/v1/login" // 임시
        );
    }

    /**
     * HTTP 요청에 대한 필터 체인 설정
     */
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // CORS 설정 활성화
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                .and()
                // HTTP Basic 인증 방식 비활성화
                // REST 방식 사용 -> CSRF 방어, 폼로그인, 세션 비활성화
                .httpBasic().disable()
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 요청에 대한 인가(Authorization) 설정
                .authorizeRequests()
                // token 검증하는 페이지 인가 허가
                .antMatchers("/token/**").permitAll()
                // 메인페이지는 인가 허가
                .antMatchers("/").permitAll()
                // 그 외의 모든 요청은 인가 필요
                .anyRequest().authenticated()
                .and()
                // 로그아웃 기능 설정
                .logout().logoutSuccessUrl("/")
                .and()
                // OAuth2 인증 방식을 사용할 때 필요한 설정
                .oauth2Login()
                // 로그인 성공 시 수행할 핸들러 설정
                .successHandler(successHandler)
                // 사용자 정보를 가져오는 서비스 설정
                .userInfoEndpoint()
                .userService(oAuth2UserService);

        // JwtAuthFilter 필터를 UsernamePasswordAuthenticationFilter 필터 앞에 추가
        http.addFilterBefore(new JwtAuthFilter(tokenProvider, memberRepository), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


}