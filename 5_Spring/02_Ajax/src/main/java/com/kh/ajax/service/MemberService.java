package com.kh.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ajax.model.vo.Member;

import mapper.MemberMapper;

@Service // Service 어노테이션 필요.
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
	public Member idCheck(String id) {
		return mapper.idCheck(id);
	}
	
//	public Member btn(String id, String password, String name) {
//		return mapper.btn(id, password, name);
//	}

	public void register(Member vo) {
		mapper.register(vo);
	}
}
