package com.kh.practice.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice.ArrayList.controller.MusicController;
import com.kh.practice.ArrayList.model.Music;


public class Application {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		MusicController mc = new MusicController();
		ArrayList<Music> music = new ArrayList<>();
		
		{
//			music.add(new music("밥을 지어요", true, 0));
//			music.add(new music("오늘은 아무래도 덮밥", false, 0));
//			music.add(new music("원피스 108", false, 15));
//			music.add(new music("귀멸의 칼날 23", false, 19));
		}
		
		Application app = new Application();
		app.menu();
	}
	
	public void menu() {
		
		boolean close = true;
		while(close) {
		System.out.println("===== 메인 메뉴 =====");
		System.out.println("1. 마지막 위치에 곡 추가");
		System.out.println("2. 첫 위치에 곡 추가");
		System.out.println("3. 전체 곡 목록 출력");
        System.out.println("4. 특정 곡 검색");
        System.out.println("5. 특정 곡 삭제");
        System.out.println("6. 특정 곡 수정");
        System.out.println("7. 가수 명 내림차순 정렬");
        System.out.println("8. 곡 명 오름차순 정렬");
        System.out.println("9. 종료");
        System.out.print("메뉴 번호 입력 : ");
//      int menuNum = Integer.parseInt(sc.nextLine());
        
        mc.addMember(name, age);
        
        switch(Integer.parseInt(sc.nextLine())) {
		case 1:
			// 마지막위치에 곡 추가
			myPage();
			break;
		case 2:
			// 첫 위치에 곡 추가
			break;
		case 3:
			musicList();
			// 전체 곡 목록 출력
			break;
		case 4:
			// 특정 곡 검색
			break;
		case 5:
			// 특정 곡 삭제
			break;
		case 6:
			// 특정 곡 수정
			break;
		case 7:
			// 가수 명 내림차순 정렬
			break;
		case 8:
			// 곡 명 오름차순 정렬
			break;
		case 9:
			System.out.println("종료");
			//check = false;
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
		}
	}
}
        
  public void myPage() {
	  System.out.println("****** 마지막 위치에 곡 추가 ******");
	  System.out.print("곡 명 : ");
	  String title = sc.nextLine();
	  
	  System.out.print("가수 명 : ");
	  String artist = sc.nextLine();
	  
  }
  
  public void musicList() {
	  System.out.print("****** 전체 곡 목록 출력 ******");
	  
  }
  
}



//		int select = 0;
//		
//		try {
//			select = Integer.parseInt(sc.nextLine());
//		} catch (Exception e) {
//		
//		}
//			switch(select) {
//		}
			