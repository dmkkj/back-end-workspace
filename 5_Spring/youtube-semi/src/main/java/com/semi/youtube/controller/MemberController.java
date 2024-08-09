package com.semi.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.youtube.service.MemberService;

@Controller	// Controller단 : 요청은 받았고 응답만 처리한다
public class MemberController {
	
	@Autowired
	private MemberService member;
	
	// 중복체크
	@ResponseBody
	@PostMapping("/check")
	public boolean check(String id) {
		System.out.println(id);
		return member.check(id);	// member가 없으면 null, 있으면 객체 보내는 것 확인?
	}
	
	
	
	// 회원가입
	
	
	// 로그인
	
	
}
