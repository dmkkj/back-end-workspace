package com.kh.practice;

import java.util.Scanner;

import com.kh.variable.B_Casting;

public class VariablePractice {
	
	public static void main(String[] args) {

		VariablePractice method1 = new VariablePractice();
		method1.method1();
		method1.method2();
//		method1.method3();
//		method1.method4();
//		method1.method5();
		method1.method6();
		method1.method7();
	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */
	public void method1() {
		
		int adult = 10000;
		int teenager = 7000;
		
		int adultNum = 2;
		int teenagerNum = 3;
		
		int adultSum = adult * adultNum;
		int teenagerSum = teenager * teenagerNum;
		
		int sum = adultSum + teenagerSum;
		
		System.out.println("--- method1.result ---");
		System.out.println("지불해야 할 금액은 " + sum + "원입니다.");
		System.out.println();
	}
	
	/*
	 * x=5, y=7, z=9의 값을 직접 변경하지 않고 변수를 사용하여
	 * 
	 * x=7
	 * y=9
	 * z=5
	 * 
	 * 로 출력하세요.
	 * */
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		System.out.println("--- method2.result ---");
		System.out.println("x= " + x);
		System.out.println("y= " + y);
		System.out.println("z= " + z);
		System.out.println();
	}

	/*
	 * 정수 두 개를 입력 받아 두 수의 합(+), 차(-), 곱(*), 나누기(/)한 몫을 출력하세요.
	 * 
	 * 첫 번째 정수 : 23
	 * 두 번째 정수 : 7
	 * 더하기 : 30
	 * 빼기 : 16
	 * 곱하기 : 161
	 * 나누기 몫 : 3
	 * */
//	public void method3() {
//
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("--- method3.result ---");
//		System.out.print("첫 번째 정수 : ");
//		int num1 = sc.nextInt();
//		
//		System.out.print("두 번째 정수 : ");
//		int num2 = sc.nextInt();
//		
//		int sum = num1 + num2;
//		int sub = num1 - num2;
//		int mul = num1 * num2;
//		int quo = num1 / num2;
//
//		System.out.println("더하기 : " + sum
//						 + "\n빼기 : " + sub
//						 + "\n곱하기 : " + mul
//						 + "\n나누기 몫 : " + quo);
//		System.out.println();
//	}

	/*
	 * 키보드로 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식) 면적 : 가로 * 세로
	 *       둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 : 562.95
	 * 둘레 : 110.4
	 * */
//	public void method4() {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("--- method4.result ---");
//		System.out.print("가로 : ");
//		double width = sc.nextDouble();
//		
//		System.out.print("세로 : ");
//		double height = sc.nextDouble();
//		
//		double area = width * height;
//		double size = (width + height) * 2;
//		
//		System.out.print("면적 : " + area + "\n");
//		System.out.print("둘레 : " + size);
//		System.out.println();
//	}

	/*
	 * 영어 문자열 값을 입력 받아 문자에서 첫번째, 두번째, 마지막 글자(문자열.length())를 출력하세요.
	 * 
	 * 문자열을 입력하세요 : apple
	 * 첫번째 문자 : a
	 * 두번째 문자 : p
	 * 마지막 문자 : e
	 * */
//	public void method5() {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("--- method5.result ---");
//		System.out.print("문자열을 입력하세요 : ");
//		
//		String input = sc.nextLine();
//		
//		char input1 = input.charAt(0);
//		System.out.print("첫번째 문자 : " + input1 + "\n");
//				
//		char input2 = input.charAt(1);
//		System.out.print("두번째 문자 : " + input2 + "\n");
//		
//		char input3 = input.charAt(input.length()-1);
//		System.out.print("마지막 문자 : " + input3);
//		System.out.println();
//	}

	/*
	 * 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	 * 
	 * 문자 : A
	 * A unicode : 65
	 * B unicode : 66
	 * */
	public void method6() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("--- method6.result ---");
		System.out.printf("문자 : ");
		String input = sc.nextLine();
		
		int num = 'A';
		System.out.printf(input + " unicode : " + num + "\n");
		
		num += 1;
		System.out.printf(input + " unicode : " + num);
	}
	
	
	// char <-> int : 각 문자들마다 고유한 숫자가 지정되어 있기 때문 (유니코드, 아스키코드)
			// 쌍방향으로 형변환 가능
			// char는 음수값 저장 불가 => 값의 범위가 0 ~ 65535
//			
//			int num = 'A';
//			System.out.println(num); // 65
//			
//			char ch = 52143;
//			System.out.println(ch); // 쮯	
//	
	
	
	/*
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	 * 
	 * 국어 : 75
	 * 영어 : 63
	 * 수학 : 80
	 * 총점 : 218
	 * 평균 : 72.67
	 * */
	public void method7() {

	}

}
