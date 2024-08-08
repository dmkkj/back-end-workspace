package com.kh.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/ajax1")
	public String ajax1() {
		return "01_count";
	}
	
	@GetMapping("/ajax2") // /ajax2 경로 지정
	public String ajax2() {
		return "02_encoding"; // 02_encoding.jsp로 가겠다
	}

	@GetMapping("/ajax3")
	public String ajax3() {
		return "03_register";
	}
	
}

