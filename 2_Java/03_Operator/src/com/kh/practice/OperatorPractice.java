package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
    
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		OperatorPractice op = new OperatorPractice();
//		op.method1();
//		op.method2();
//		op.method3();
//		op.method4();
//		op.method5();
//		op.method6();
		op.method7();
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		
		System.out.print("인원 수 : ");
		int person = sc.nextInt();
		System.out.print("연필 개수 : ");
		int pencil = sc.nextInt();
		
		int div = person / pencil;
		int mod = person % pencil;
		
		System.out.println("1인당 연필 개수 : " + div + "개");
		System.out.println("남은 연필 개수 : " + mod + "개");
		
	}
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {

		System.out.print("입력 받은 숫자 : ");
		int num = sc.nextInt();
		
		int result = num - (num % 100);
		System.out.print(result);
		
	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {

		System.out.print("입력 값 1 : ");
		int num1 = sc.nextInt();
		System.out.print("입력 값 2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력 값 3 : ");
		int num3 = sc.nextInt();
		
		boolean check = (num1 == num2 && num2 == num3);
		System.out.println(check);
		
	}

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {

		System.out.print("입력할 정수 : ");
		int num = sc.nextInt();
		
		String result = num % 2 == 0 ? "짝수" : "짝수가 아니다";
		System.out.println(result);
		
	}

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요
	public void method5() {
		
		System.out.print("주민등록번호를 입력하시오 : ");
		//String pno = sc.nextLine();
		char pno = sc.nextLine().charAt(7);
		
		String gender = (pno == '1' || pno == '3') ? "남자" : (pno == '2' || pno == '4') ? "여자" : "뒷자리를 다시 확인해 주세요.";
		System.out.println(gender);

	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 성인(19세 초과)인지 출력하세요.
	public void method6() {
	
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		String result = (age <= 13) ? "어린이" : (13 < age && age <= 19) ? "청소년" : "성인";
		System.out.println(result);
		
	}

	//사과의 개수와 바구니의 크기(바구니 1개에 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		
		System.out.print("사과의 개수 : ");
		int apple = sc.nextInt();
		System.out.print("바구니의 크기 : ");
		int size = sc.nextInt();
		
		int count = apple / size;
		int need = apple % size;
		System.out.println("필요한 바구니의 수 : " + count);
		System.out.println("남는 사과 : " + need);
		
	}
	
}