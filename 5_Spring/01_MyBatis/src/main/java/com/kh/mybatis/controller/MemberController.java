package com.kh.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
// 항상 요청 받는 것은 controller
	
	@Autowired
	private MemberService service;
	
//	public MemberController(MemberService service) {
//		this.service = service;
//	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allMember", service.allMember());
		return "index";
	}
	
	// 회원가입
	@GetMapping("/register")
	public String register() {
		return "mypage/register"; // 해당하는("mypage/register") 페이지를 보여달라는 것. 해당 페이지로.
	}
	
	@PostMapping("/register")
	public String register(Member vo) {
		service.register(vo);
		return "redirect:/"; // @GetMapping("/") return "index"; 호출. redirect:/는 다시 요청
	}
	
	// 로그인
	@GetMapping("/login")
	public String login() {
		return "mypage/login";
	}
	
	@PostMapping("/login")
	public String login(Member vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("vo", service.login(vo));
		return "redirect:/";
	}
	
//	@PostMapping("/login")
//	public String logout(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		session.setAttribute("vo", service.login(vo));
//		return "redirect:/";
//	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("vo");
		if(member!=null) session.invalidate();
		return "redirect:/";
	}
	
	// 회원정보수정
	@PostMapping("/update") // 보내는 것
	public String update(Member vo, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("vo");
		
		if(vo.getId()==null) vo.setId(member.getId());
		System.out.println(vo);
		service.update(vo);
		
		if(vo.getName()==null) vo.setName(member.getName());
		session.setAttribute("vo", vo);
		
		return "redirect:/";
	}	
		/*
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("vo");
		
		if(vo.getName()==null) {
			vo.setId(member.getId());
			vo.setName(member.getName());
			service.updatePwd(vo);
		} else {
			service.update(vo);
		}
		session.setAttribute("vo", vo);
		
		return "redirect:/";
		*/
	
	@GetMapping("/search")
	public String search(SearchDTO dto, Model model) {
		model.addAttribute("search", service.search(dto));
		return "index";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam(name="idList", required=false) List<String> idList) {
		if(idList!=null) service.delete(idList);
		return "redirect:/";
	}
	
}