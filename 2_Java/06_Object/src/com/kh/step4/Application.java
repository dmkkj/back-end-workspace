package com.kh.step4;

import com.kh.step4.model.Car;

public class Application {

	public static void main(String[] args) {

		Car c = new Car(); // 객체 생성
		
		/*
		c.color = "red";
		c.gearType = "auto";
		c.door = 4;
		*/
		
		// Car car1 = new Car(); // public Car() {} 생성한다는 것
		Car car1 = new Car("white", "auto", 4);
		Car car2 = new Car("black", "manual");
		
		System.out.println(car1);
		System.out.println(car2);
	}

	/*
	 * 오버로딩 : 한 클래스 내에 동일한 이름의 메서드를
	 * 			매개변수의 자료형과 개수, 순서가 다르게 작성되어야 함
	 * */
	void test() {} // 메서드 만들기
	void test(int a) {} // 메서드명이 같아도 매개변수 개수가 다르면 사용 가능
//	void test(int b) {} // 매개변수 개수는 같고, 변수명이 다른 건 오버로딩 아님
	void test(int b, String s) {} // 오버로딩 가능. int 값 1개, String 값 1개 받기 때문
	void test(String s, int b) {} // 문자열부터 받는 메서드구나. 해서 다른 걸로 인지. 오버로딩 가능
	void test(int a, int b) {} // 오버로딩 가능
	
}
