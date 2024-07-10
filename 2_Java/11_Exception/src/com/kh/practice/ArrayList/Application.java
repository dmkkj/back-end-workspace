package com.kh.practice.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice.ArrayList.model.Music;

public class Application {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		ArrayList<Music> m = new ArrayList<>();
		
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
//        int menuNum = Integer.parseInt(sc.nextLine());
        
        int select = 0;
		
		try {
			select = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
		
		}
			switch(select) {
					case 1:
						// 마지막위치에 곡 추가
						m.
						break;
					case 2:
						// 첫 위치에 곡 추가
						break;
					case 3:
						// 전체 곡 목록 출력
						break;
					case 4:
						// 특정 곡 검색
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						break;
					case 8:
						break;
					case 9:
						System.out.println("종료");
						check = false;
						break;
					default:
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				}
			
			
			
	}

}
