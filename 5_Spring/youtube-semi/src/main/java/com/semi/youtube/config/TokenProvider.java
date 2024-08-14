package com.semi.youtube.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.semi.youtube.model.vo.Member;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenProvider {

	private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	// SecretKey 가지고 Token 만들기. member 정보 가지고 Token 만들어 지는 것
	public String create(Member member) { // Member 정보 가져다가 담아보기
		return Jwts.builder()
				.signWith(secretKey)
				.setClaims(Map.of( // 정보 한꺼번에 집어넣을 때 사용
						"id", member.getId(),
						"name", member.getName(),
						"role", member.getRole()
				))
				.setIssuedAt(new Date())
				.setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
				.compact();
	}
	
	public Member validate(String token) {
		Claims claims = Jwts
							.parser()
							.setSigningKey(secretKey)
							.parseClaimsJws(token)
							.getBody();
		return Member.builder()
				.id((String) claims.get("id"))
				.name((String) claims.get("name"))
				.role((String) claims.get("role"))
				.build();
	}
	
}
