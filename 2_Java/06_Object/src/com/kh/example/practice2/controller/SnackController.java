package com.kh.example.practice2.controller;

import com.kh.example.practice2.model.Snack;

public class SnackController {
	
	private Snack s = new Snack(); // 해당하는 controller 내에서만 사용 가능한 변수 생성(private)
	
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		// 데이터를 setter를 이용해 저장하고 "저장 완료되었습니다." 결과를 반환하는 메서드
		
//		Snack snack = new Snack();
//		snack.setKind(kind);
//		snack.setName(name);
//		snack.setFlavor(flavor);
//		snack.setNumOf(numOf);
//		snack.setPrice(price);
		
		/*
		s = new Snack(kind, name, flavor, numOf, price);
		System.out.println(s);
		return "저장 완료되었습니다.";
		*/
		
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		
		return "저장 완료되었습니다.";
//		return null; // 개발 중일때는 기본값 지정해놓으면 됨
		
	}
	
	public String confirmData() {
		// 저장된 데이터를 반환
		return s.getKind() + "(" + s.getName() + " - " + s.getFlavor()
				+ ") " + s.getNumOf() + "개 " + s.getPrice() + "원";
		
		//return System.out.println(snack.getKind() + "(" + snack.getName() + " - " + snack.getFlavor() + ") " + snack.getNumOf() + "개 " + snack.getPrice() + "원");
		//return kind + "(" + name + " - " + flavor + ")" + numOf + " 개 " + price + "원";
	}
}
