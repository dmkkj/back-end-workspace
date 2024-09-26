package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.domain.Movie;
import com.jpa.repo.MovieDAO;

@Service
public class MovieService {

	@Autowired
	private MovieDAO dao;
	
	// 추가 메서드
	public void change(Movie vo) {
		dao.save(vo); // id가 없으면 추가, 있으면 수정. 추가/수정 둘다 가능. save() : 자동으로 추가/수정 해주는 메서드
	}
	
	// 전체 리스트 가져오는 메서드
	public List<Movie> viewAll() {
		return dao.findAll();
	}
	
	// 1개 보기
	public Movie view(int id) {
		//return dao.findById(id).get();
		return dao.findById(id).orElse(null);
	}
	
	// 삭제
	public void delete(int id) {
		dao.deleteById(id); // 데이터 삭제 시 워낙 primary key로 삭제하는 경우가 많아서 아예 메서드가 있음
	}
}
