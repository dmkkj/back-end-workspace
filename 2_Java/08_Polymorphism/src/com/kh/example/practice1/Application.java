package com.kh.example.practice1;

import java.util.Scanner;

import com.kh.array.practice2.model.Member;
import com.kh.example.practice1.controller.MemberController;

public class Application {

	Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
	}
	
	public void mainMenu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
	
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		
		boolean check = true;
		while(check) {
			System.out.print("==== 메뉴 ====");
			System.out.print("1. 마이페이지");
			System.out.print("2. 도서 대여하기");
			System.out.print("3. 프로그램 종료하기");
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
		Member m = new Member(name, age, coupon, bookList);
		mc.memberPage(m);
	}
	
	// 도서대여하기
	public void bookRent() {
		
	}
}
