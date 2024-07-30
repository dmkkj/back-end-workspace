package com.kh.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mybatis.model.vo.Member;

import mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
//	public MemberService(MemberMapper memberMapper) {
//		this.memberMapper = memberMapper;
//	}
	
	public void register(Member member) {
		mapper.register(member);	// MemberMapper.java와 member.xml에서 1:1 매핑한 member 값을 여기에서 불러옴
	}
	
	
}
