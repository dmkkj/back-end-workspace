package com.kh.example.practice1;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.array.practice1.model.Student;
import com.kh.array.practice2.model.Member;
import com.kh.example.practice1.controller.MemberController;

public class Application {

	Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
		
		//String[] arr = new String[5]; // String 자바가 제공하는 기본 클래스
		BookList[] arr = new BookList[4];
		
		arr[0] = new BookList("박성철", "자바", 100);
		arr[1] = new BookList("이진우", "디비", 95);
		arr[2] = new BookList("이준용", "자바", 97);
		arr[3] = new BookList("김경주", "화면", 98);
		arr[4] = new BookList("김현호", "자바", 95);
		
		System.out.println(Arrays.toString(arr)); // 클래스의 초기값 null만 5개 들어가있음	// [null, null, null, null, null]
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println();
		
		for(Student student : arr) {
			System.out.println(student);
		}
	}
		
		
		
		
		
		
		
		
		
		
	}
	
	public void mainMenu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
	
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		
		boolean check = true;
		while(check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			
		int select = Integer.parseInt(sc.nextLine());
			switch(select) {
				case 1:
					memberPage();
					break;
				case 2:
					bookRent();
					break;
				case 3:
					System.out.println("");
					check = false;
					break;
			}
		}
	}

	// 마이페이지
	public void memberPage() {
//		Member m = new Member(name, age, coupon, bookList);
//		mc.memberPage(m);
	}
	
	// 도서대여하기
	public void bookRent() {
		
	}
}
