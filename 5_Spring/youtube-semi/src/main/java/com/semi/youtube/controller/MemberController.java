package com.semi.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.youtube.model.vo.Member;
import com.semi.youtube.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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
	
	// 로그인
	@PostMapping("/login")
	public String login(Member vo, HttpServletRequest request) {
		Member result = member.login(vo);
		if(result!=null) { // 제대로 로그인 됐을 때
			HttpSession session = request.getSession();
			session.setAttribute("vo", result);
			return "redirect:/";	
		}
		return "login";
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	// 회원가입
	@PostMapping("/signup")
	public String signup(Member vo) {
		member.signup(vo);
		return "redirect:/";
	}
	

	
	
}
