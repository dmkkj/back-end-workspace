package com.kh.example.practice1;

import com.kh.example.practice1.model.Member;

public class Application {

	public static void main(String[] args) {
		Member member = new Member();
		member.changeName("race!"); // 값 입력 가능한 이유 : Member.java > public void changeName(String name) {} String으로 지정했기 때문에 값 입력 가능
		member.printName();
	}

}
