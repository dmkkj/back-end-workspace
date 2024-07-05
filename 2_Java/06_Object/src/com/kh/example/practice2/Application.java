package com.kh.example.practice2;

import java.util.Scanner;

import com.kh.example.practice2.controller.SnackController;
import com.kh.example.practice2.model.Snack;

public class Application {

	public static void main(String[] args) {
		// ------------------------ 화면 ------------------------
		Scanner sc = new Scanner(System.in);
		
//		Snack snack = new Snack();
//		snack.setKind("빵");
//		snack.setName("케이크");
//		snack.setFlavor("블루베리");
//		snack.setNumOf(1);
//		snack.setPrice(15000);
		
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		String kind = sc.nextLine();
//		System.out.println(snack.getKind());
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
//		System.out.println(snack.getName());
		
		System.out.print("맛 : ");
		String flavor = sc.nextLine();
//		System.out.println(snack.getFlavor());
		
		System.out.print("개수 : ");
		int numOf = Integer.parseInt(sc.nextLine());
//		System.out.println(snack.getNumOf());
		
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
//		System.out.println(snack.getPrice());	
		// -----------------------------------------------------
		// --> 즉, 여기까지는 controller나 model에 직접 접근 X
		
		// 데이터들을 서버한테 요청! 서버한테 전달할 때는 controller로! (내가 입력받은 값 저장해줘)
		SnackController controller = new SnackController();
		
		// 서버한테 요청해서 응답받은 결과를 다시 화면으로!
		System.out.println(controller.saveData(kind, name, flavor, numOf, price));
		System.out.println(controller.confirmData());
		
//		System.out.println("저장 완료되었습니다.");
		
//		System.out.println(kind + "(" + name + " - " + flavor 
//				+ ") " + numOf + "개 " + price + "원");
		
		/* 방법 1
		Snack snack = new Snack(kind, name, flavor, numOf, price);
		System.out.println(snack);
		*/
				
		/* 방법 2
		Snack snack = new Snack();
		snack.setFlavor(flavor);
		snack.setKind(kind);
		snack.setName(name);
		snack.setNumOf(numOf);
		snack.setPrice(price);
		System.out.println(snack);
		*/
		
		//System.out.println(snack.getKind() + "(" + snack.getName() + " - " + snack.getFlavor() + ") " + snack.getNumOf() + "개 " + snack.getPrice() + "원");
		
//		snack.saveData();
//		snack.confirmData();
	}

}
