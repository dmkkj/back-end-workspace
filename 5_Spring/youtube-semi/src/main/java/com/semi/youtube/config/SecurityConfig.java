package com.semi.youtube.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// 특정 http 요청에 대한 웹 기반 보안 구성. 인증/인가 및 로그아웃 설정
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable())	// 내부 접근 차단 못하게 아예 막아버리는 애
				.formLogin(login ->
					login.loginPage("/login") // 로그인 페이지 등록
						.defaultSuccessUrl("/", true) // 로그인 성공했을 때
						.permitAll()
				)
				.logout(logout ->
					logout
						.logoutUrl("/logout") // 로그아웃 요청 URL
						.logoutSuccessUrl("/") // 로그아웃 성공했을 때
						.permitAll()
				)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)) // session 쓰겠다
				.authorizeHttpRequests(authorize ->
					authorize
						.requestMatchers("/like", "/unlike").authenticated() // 인증된 사람만 쓸 수 있게
						.anyRequest().permitAll()
				)
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
