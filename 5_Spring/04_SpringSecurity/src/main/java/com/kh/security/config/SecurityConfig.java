package com.kh.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// 특정 http 요청에 대한 웹 기반 보안 구성. 인증/인가 및 로그아웃 설정
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable())	// 내부 접근 차단 못하게 아예 막아버리는 애
				.authorizeHttpRequests(authorize ->
					authorize
						// .requestMatchers("/register").authenticated()
						.anyRequest().permitAll()
				)
//				.formLogin(login ->
//						login
//							.loginPage("/login")
//							.defaultSuccessUrl("/", true)
//							.permitAll()
//				)
				.build();
	}
	
}
