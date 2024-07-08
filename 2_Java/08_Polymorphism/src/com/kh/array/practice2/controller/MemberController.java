package com.kh.array.practice2.controller;

import java.util.Arrays;

import com.kh.array.practice2.model.Member;

public class MemberController {
	
	/* 완전 자유롭게! */ // Controller 직접 뽑아보세요
	private Member[] mArr = new Member[3];
	public int count = 0;
	
	// 멤버 추가
	public void insertMember(Member m) {
		mArr[count++] = new Member(m.getId(), m.getName(), m.getPwd(), 
								m.getEmail(), m.getGender(), m.getAge());
		System.out.println(Arrays.toString(mArr));
	}

	// 멤버 아이디 검색 -> 멤버 index를 아이디로 조회
	public int checkId(String id) {
		for(int i = 0; i < mArr.length; i++) {
			if(mArr[i] != null && mArr[i].getId().equals(id)) {
				// 기존 멤버 배열에 아이디가 있는 경우!
				return i;
			}
		}
		// 아이디가 없는 경우
		return -1;
	}
	
	// 멤버 수정
	public void updateMember(String id, String name, String pwd, String email) {
		// 해당하는 멤버의 index 찾기!
		int index = checkId(id);
		mArr[index].setName(name);
		mArr[index].setEmail(email);
		mArr[index].setPwd(pwd);
	}
	
	// 멤버 조회
	public Member[] printAll() {
		return mArr;
	}
}
	/*
	public void add(String id, String name, String pwd, String email) {
		
		for(int i = 0; i < mArr.length; i++) {
			mArr[i].setId(id);
			mArr[i].setName(name);
			mArr[i].setPwd(pwd);
			mArr[i].setEmail(email);
		}
		
	}
	
	public void add(String id, String name, String pwd, String email, char gender, int age) {
		mArr[0].setId(id);
		mArr[0].setName(name);
		mArr[0].setPwd(pwd);
		mArr[0].setEmail(email);
		mArr[0].setGender(gender);
		mArr[0].setAge(age);
		
		mArr[1].setId(id);
		mArr[1].setName(name);
		mArr[1].setPwd(pwd);
		mArr[1].setEmail(email);
		mArr[1].setGender(gender);
		mArr[1].setAge(age);
		
		mArr[2].setId(id);
		mArr[2].setName(name);
		mArr[2].setPwd(pwd);
		mArr[2].setEmail(email);
		mArr[2].setGender(gender);
		mArr[2].setAge(age);
	}
	
	public void modify(String id) {
		mArr[0].setId(id);
		mArr[1].setId(id);
		mArr[2].setId(id);
	}
	
*/

