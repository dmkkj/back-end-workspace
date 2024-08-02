package com.semi.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.semi.youtube.service.VideoService;

@Controller
public class PageController {
	
	@Autowired
	public VideoService video;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println(video.allVideo());
		model.addAttribute("list", video.allVideo());
		return "index";
	}
	
	// http://localhost:8080/watch?v=2
	@GetMapping("/{videoCode}")
	public String detail(@PathVariable("videoCode") String videoCode) {
		System.out.println(videoCode);
		return "detail";
	}

}
