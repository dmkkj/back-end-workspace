package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;
import com.kh.upload.service.BoardService;

/*
 * REST(Representational State Transfer)
 *  : API를 설계하는 아키텍처
 * 
 * RESTful : REST 원칙을 준수하는 방식
 * 
 * API(Application Programming Interface) 
 *  : 서로 다른 애플리케이션들이 서로 데이터를 주고 받을 수 있게 하는 도구
 * */

@RestController
@RequestMapping("/api/*") // http://localhost:8080/api
//@RequestMapping("/api/v1/*") .. @RequestMapping("/api/v2/*") .. api 버전업 할 때 이렇게 명시!
public class BoardController {
	
	private String path = "\\\\192.168.10.51\\upload\\";
	
	// BoardService.java 만들어놓고 service단 주입시키기
	@Autowired
	private BoardService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	/*
	public void fileUpload(MultipartFile file) throws IllegalStateException, IOException {	
		// 중복 방지를 위한 UUID 적용
		UUID uuid = UUID.randomUUID();
		//System.out.println(uuid.toString());
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		
		File copyFile = new File("D:\\upload\\" + fileName);
		file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 저장
	}
	*/
	
	public String fileUpload(MultipartFile file) throws IllegalStateException, IOException {	
		// 중복 방지를 위한 UUID 적용
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		
		File copyFile = new File("\\\\192.168.10.51\\upload\\" + fileName);
		file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 저장
		return fileName;
	}
	
	// CRUD : Create - Post, Read - Get, Update - Put, Delete - Delete
	
	// Create - Post
	@PostMapping("/board")
	public ResponseEntity write(Board vo) throws IllegalStateException, IOException {
		// 1. 파일 업로드 처리
		String url = fileUpload(vo.getFile());
		vo.setUrl(url);
		
		// 2. 해당 파일 URL과 함께 title, content DB에 저장
		service.insert(vo);
		
		return ResponseEntity.status(HttpStatus.OK).build(); // 200 OK 뜨면 제대로 돌아가고 있는 것(성공했다)
	}
	
	// Read - Get : 전체 목록 보기
	@GetMapping("/board") // 메소드가 달라서 상관없음. 위에 쟤는 Post, 얘는 Get
	public ResponseEntity list(Paging paging) {
	// public String list(Model model, Paging paging) {
	// api 호출하는 방식이면 데이터만 필요하기 때문에 굳이 담아내는 model 필요 없음
		
		List<Board> list = service.selectAll(paging); // DB에서 게시글 리스트 가져오기
		
		for(Board b : list) {
			LocalDateTime date = b.getDate();
			Date formatDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
			b.setFormatDate(formatDate);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(new BoardDTO(list, new Paging(paging.getPage(), service.total())));
		//model.addAttribute("list", list);
		//model.addAttribute("paging", new Paging(paging.getPage(), service.total()));
		
		//return ResponseEntity.status(HttpStatus.OK).body(list); // list 형식이니까 배열로, json 방식으로 데이터 가져와서 뿌려줌
		// 페이징 처리 되어 있어 같이 받으려고 했더니 body(list, new Paging(paging.getPage(), service.total())); 이거 안 됨
		// body는 하나의 객체밖에 안 보내져! 그럼 어떻게 해? 포장해서 보내면 됨. BoardDTO 하나 만들기
		// model로 보냈던 것들 body로 보낸다고 생각하기
	}
	
	// Read - Get : 1개 가져오기
	@GetMapping("/board/{no}") // 보통 데이터 1개 가져오기는 해당하는 Primary Key로 가져오기 때문에 ../{no}
	public ResponseEntity view(@PathVariable int no) {
		// 없는 데이터에 대한 상태처리를 200 OK가 아니라 다른 걸로 하고 싶을 때
		Board board = service.select(no);
		// System.out.println(board); // null -> '아 그러면 null일 때 요청을 바꾸면 되겠구나' 생각!
		if(board!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(board);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
		
	}
		
	// Update - Put
	@PutMapping("/board")
	public ResponseEntity update(Board vo) throws IllegalStateException, IOException {
			
		if(!vo.getFile().isEmpty()) {
			// 파일이 비어있지 않다면 기존 이미지 삭제(delete)
			if(vo.getUrl()!=null) { // 기존 이미지가 null이 아닌 경우
				File file = new File(path + vo.getUrl());
				file.delete();
			}
						
			// 새 이미지 등록
			String url = fileUpload(vo.getFile());
			vo.setUrl(url);
		}
		service.update(vo);
	
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	// Delete - Delete
	@DeleteMapping("/board/{no}")
	public ResponseEntity delete(@PathVariable int no) {
		 
		 // 업로드한 파일 삭제 (필요한 건 URL)
		 Board board = service.select(no);
		 if(board.getUrl()!=null) {
			 File file = new File(path + board.getUrl());
			 file.delete();
		 }
		 service.delete(no);
		 return ResponseEntity.status(HttpStatus.OK).build();
	 }
	
}
