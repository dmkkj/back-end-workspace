package com.kh.upload.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.model.vo.Board;

import mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;

	public void register(Board board) {
		
		if(board.getFile() != null && board.getFile().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString() + "_" + board.getFile().getOriginalFilename();
		
			File file = new File("D:\\upload\\" + fileName);
		
			try {
				board.getFile().transferTo(file);
				board.setUrl(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		mapper.register(board);
	}
	
	public List<Board> allBoard() {
		return mapper.allBoard();
	}
	
}
