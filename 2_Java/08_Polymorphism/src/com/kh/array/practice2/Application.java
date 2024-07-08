package com.kh.array.practice2;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.array.practice1.model.Student;
import com.kh.array.practice2.controller.MemberController;
import com.kh.array.practice2.model.Member;

public class Application {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
		
		//boolean check = true;
		/*
		Member[] arr = new Member[3];
		
		arr[0] = new Member();
		arr[1] = new Member();
		arr[2] = new Member();
		
		System.out.println(Arrays.toString(arr)); // 클래스의 초기값 null만 5개 들어가있음	// [null, null, null, null, null]
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println();
		 */	
		
		/*
		while(check) {
			int select = app.mainMenu();
			switch(select) {
			case 1:
				app.insertMember();
				break;
			case 2:
				app.updateMember();
				break;
			case 3:
				app.printAll();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				check = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					
			}
		}
		*/
	}
	
	/*
	 * 회원 수 3명 최대 등록 가능
	 * 3명 모두 등록되면 "회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다."와 함께
	 * 1. 새 회원 등록하지 못하게 화면상 보이지 않게 처리!
	 * 
	 * 최대 등록 가능한 회원 수는 3명입니다.
	 * 현재 등록된 회원 수는 ~~명입니다.
	 * 1. 새 회원 등록 -> insertMember() 
	 * 2. 회원 정보 수정 -> updateMember()
	 * 3. 전체 회원 정보 출력 -> printAll()
	 * 9. 끝내기 -> 프로그램 종료
	 * 그 외의 번호 -> 잘못 입력하셨습니다. 다시 입력해주세요
	 * 
	 * 메뉴 번호 : 
	 * */
	public void mainMenu() {
		boolean check = true;
		while(check) {
		System.out.println("최대 등록 가능한 회원 수는 3명입니다.");
		System.out.println("현재 등록된 회원 수는 " + mc.count +"명입니다.");
		
		if(mc.count < 3) {
			System.out.println("1. 새 회원 등록");
		} else {
			System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
		}
		
		System.out.println("2. 회원 정보 수정");
		System.out.println("3. 전체 회원 정보 출력");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");
		
//		return Integer.parseInt(sc.nextLine());
		int select = Integer.parseInt(sc.nextLine());
			switch(select) {
				case 1:
					insertMember();
					break;
				case 2:
					updateMember();
					break;
				case 3:
					printAll();
					break;
				case 9:
					System.out.println("프로그램 종료");
					check = false;
					break;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		}
	}

	/*
	 * 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 있는 경우
	 * "중복된 아이디입니다. 다시 입력해주세요." 출력 후
	 * 다시 아이디 입력부터 나올 수 있게 처리
	 * 
	 * 아이디 :
	 * 이름 :
	 * 비밀번호 :
	 * 이메일 :
	 * 성별(M/F) :
	 * 나이 :
	 * */
	public void insertMember() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
//		if(id == 기존멤버배열에있는아이디) {
		if(mc.checkId(id) != -1) { // 나머지 값이 -1 값이 있을 때 ?
			System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
//			System.out.print("아이디 : ");
//			String id = sc.nextLine();
			insertMember();
			
		} else {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			System.out.print("이메일 : ");
			String email = sc.nextLine();
			System.out.print("성별(M/F) : ");
			char gender = sc.nextLine().charAt(0);
			System.out.print("나이: ");
	//		int age = sc.nextInt();
			int age = Integer.parseInt(sc.nextLine());
		
	//		mc.add(id, name, pwd, email);
			Member m = new Member(id, name, pwd, email, gender, age);
			mc.insertMember(m);
		}
	}
	
	/*
	 * 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 없는 경우
	 * "회원 정보가 없습니다." 출력 후 다시 메인 화면으로
	 * 
	 * 수정할 회원의 아이디 :
	 * 수정할 이름 :
	 * 수정할 이메일 :
	 * 수정할 비밀번호 :
	 * */
	public void updateMember() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		if(mc.checkId(id) == -1) {
			System.out.println("회원 정보가 없습니다.");
			return;
		}
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		System.out.print("수정할 비밀번호 : ");
		String pwd = sc.nextLine();
		System.out.print("수정할 이메일 : ");
		String email = sc.nextLine();
		mc.updateMember(id, name, pwd, email);
	}
	
	/*
	 * 전체 회원 정보 출력 (반복문 사용)
	 * */
	public void printAll() {
		Member[] mArr = mc.printAll();
		for(Member m : mArr) {
			if(m!=null) System.out.println(m);
		}
	}
}
