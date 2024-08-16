package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.vo.Board;
import com.kh.upload.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	public void fileUpload(MultipartFile file) throws IllegalStateException, IOException {	
		// 중복 방지를 위한 UUID 적용
		UUID uuid = UUID.randomUUID();
		//System.out.println(uuid.toString());
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		
		File copyFile = new File("D:\\upload\\" + fileName);
		file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 저장
	}
	
	
	@PostMapping("/upload")
	public String upload(MultipartFile file) throws IllegalStateException, IOException {
		System.out.println("upload!");
//		System.out.println(file); // 찍어봤을 때 값이 null이 뜨면 <form> 태그에서 빼먹은 것이 있다고 생각하면 됨! -> enctype="multipart/form-data"
		System.out.println("파일 이름 : " + file.getOriginalFilename());
		System.out.println("파일 사이즈 : " + file.getSize());
		System.out.println("파일 파라미터명 : " + file.getName());
		
		fileUpload(file);
		
		return "redirect:/";
	}
	
	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) throws IllegalStateException, IOException {
		
		for(MultipartFile file : files) {
			fileUpload(file);
		}
		
		return "redirect:/";
	}

	/*
	@GetMapping("/list")
	public String register() {
		return "list";
	}
	*/
	
	@GetMapping("/list")
	public String register(Model model) {
		List<Board> boards = service.allBoard(); // DB에서 게시글 리스트 가져오기
		model.addAttribute("boards", boards); // 모델에 데이터 추가
		return "list"; // view 이름 (list.jsp)
	}
	
	
	@PostMapping("/list")
	public String register(Board board) {
		service.register(board);
		return "redirect:/";
	}	
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@PostMapping("/write")
	public String write(Board board) {
		service.register(board);
//		return "list";
		return "redirect:/list";
	}
	
}
