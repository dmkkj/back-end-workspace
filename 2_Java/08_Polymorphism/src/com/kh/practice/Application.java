package com.kh.practice;

import java.util.Scanner;

import com.kh.practice.model.Book;
import com.kh.practice.model.Member;

public class Application {

	Scanner sc = new Scanner(System.in);
	Member member = new Member();	// member 객체 생성
	Book[] books = {new Book("밥을 지어요", true, 0),
			new Book("오늘은 아무래도 덮밥", false, 0), 
			new Book("원피스 108", false, 15), 
			new Book("귀멸의 칼날 23", false, 19)};
	
	public static void main(String[] args) {
		Application app = new Application();	// 객체 생성
		app.menu();
	}
	
	public void menu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		member.setName(name);
		
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		member.setAge(age);
		
		/*
		boolean check = true;
		while(check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int number = Integer.parseInt(sc.nextLine());
			System.out.println(member);
		}
		
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
		*/
		System.out.println("==== 메뉴 ====");
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 대여하기");
		System.out.println("3. 프로그램 종료하기");
		System.out.print("메뉴 번호 : ");
		
		int number = Integer.parseInt(sc.nextLine());
		if(number == 1) {
			System.out.println(member);
		} else if (number == 2) {
			for(int i = 0; i < books.length; i++) {
				System.out.println((i+1) + "번 도서 : " + books[i]);
			}
			System.out.println("대여할 도서 번호 선택 : ");
			int select = Integer.parseInt(sc.nextLine());
			// select(= index+1) 번호에 따라서 해당 책이 Member - bookList에 추가
			member.getBookList()[0] = books[select-1];
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
