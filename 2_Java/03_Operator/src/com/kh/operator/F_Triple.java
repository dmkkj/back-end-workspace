package com.kh.operator;

import java.util.Scanner;

public class F_Triple {

	Scanner sc = new Scanner(System.in);
	
	/*
	 * 삼항 연산자
	 * 
	 * 조건식 ? 값1 : 값2;
	 * 
	 * - 조건식에는 주로 비교, 논리 연산자가 사용된다.
	 * - 조건식의 결과가 true이면 값1을 반환한다.
	 * - 조건식의 결과가 false이면 값2를 반환한다.
	 * */
	
	public static void main(String[] args) {
		F_Triple f = new F_Triple();
//		f.method1();
//		f.practice1();
//		f.practice2();
		f.practice3();
	}
	
	public void method1() {
		// 입력받은 정수가 양수인지 음수인지 판단
		System.out.println("정수값 >> ");
		int number = sc.nextInt();
		
		String result = number > 0 ? "양수" : "음수";
		System.out.println(result);
		
		// 0이다 포함
		result = number == 0 ? "0이다" : number > 0 ? "양수" : "음수";
		System.out.println(result);
		
	}

	
	/*
	 * 실습문제 1
	 * 사용자한테 두 개의 정수값을 입력받아서 두 정수의 곱셈 결과 100보다 크거나 같은 경우
	 * "결과가 100 이상입니다." 아닌 경우 "결과가 100 보다 작습니다." 출력
	 * */
	public void practice1() {
		System.out.print("첫 번째 정수값 : ");
		int numb1 = sc.nextInt();
		
		System.out.print("두 번째 정수값 : ");
		int numb2 = sc.nextInt();
		
		int mul = numb1 * numb2;
		String result = mul >= 100 ? "결과가 100 이상입니다." : "결과가 100 보다 작습니다.";
		System.out.println(result);
	}
	
	/* 풀이
	public void practice1() {
		System.out.print("정수값 1 > ");
		int num1 = sc.nextInt();
		
		System.out.print("정수값 2 > ");
		int num2 = sc.nextInt();
		
		String result = num1 * num2 >= 100
							? "결과가 100 이상입니다."
							: "결과가 100 보다 작습니다.";
		
		System.out.print(result);
	}
	*/
	
	
	
	/*
	 * 실습문제 2
	 * 사용자한테 문자를 하나 입력받아서 입력한 문자가 대문자이면
	 * "알파벳 대문자이다." 아닌 경우 "알파벳 대문자가 아니다." 출력
	 * */
	public void practice2() {
		System.out.print("입력 문자 : ");
		char input = sc.nextLine().charAt(0);
	
		String check = ('A' <= input && input <= 'Z') ? "알파벳 대문자이다." : "알파벳 대문자가 아니다.";
		System.out.println(check);
	}
	
	/* 풀이
	public void practice2() {
		System.out.print("문자 입력 > ");
		char word = sc.nextLine().charAt(0);
		
		String result = 'A' <= word && word <= 'Z'
							? "알파벳 대문자이다." 
							: "알파벳 대문자가 아니다.";
		System.out.println(result);
	}
	*/
	
	
	
	/*
	 * 실습문제 3
	 * 두 정수를 입력받고 + 또는 -를 입력받아서 계산을 출력
	 * 단, + 또는 - 이외의 문자를 입력하는 경우 "잘못 입력했습니다." 출력
	 * 
	 * 예시)
	 * 첫번째 수 > 3
	 * 두번째 수 > 4
	 * 
	 * 연산자 입력(+ 또는 -) > +
	 * 3 + 4 = 7
	 * 
	 * 연산자 입력(+ 또는 -) > -
	 * 3 - 4 = 1
	 * 
	 * 연산자 입력(+ 또는 -) > *
	 * 잘못 입력했습니다.
	 * */
	public void practice3() {
		System.out.print("첫 번째 수 > ");
//		int num1 = sc.nextInt();
		int num1 = Integer.parseInt(sc.nextLine()); // Enter 처리 신경 쓸 필요 없게
		
		System.out.print("두 번째 수 > ");
//		int num2 = sc.nextInt();
		int num2 = Integer.parseInt(sc.nextLine());
		
//		sc.nextLine();
		
		System.out.print("연산자 입력(+ 또는 -) > ");
		char op = sc.nextLine().charAt(0);
		// Error : Index 0 out of bounds for length 0 글자가 하나도 없는데 인덱스를 찾으려고 해서 에러

		String result = 
					op == '+'
					? num1 + "+" + num2 + "=" + (num1 + num2)
					: op == '-'
						? num1 + "-" + num2 + "=" + (num1 - num2)
						: "잘못 입력했습니다";
		// System.out.println(result);
		
		// 또 다른 방법 1 : 조건문 사용 (이건 다음주 월요일!)
		if(op == '+' || op == '-') {
			System.out.printf("%d %c %d = %d", num1, op, num2,
								op=='+' ? (num1+num2) : (num1-num2));
			System.out.println();
		} else {
			System.out.println("잘못 입력했습니다");
		}
		
		//System.out.printf("%d %c %d = %d", num1, op, num2, op=='+' ? (num1+num2) : (num1-num2));
		
		// 또 다른 방법 2
		result = op == '+'
				? String.format("%d + %d = %d", num1, num2, (num1 + num2))
				: op == '-'
					? String.format("%d - %d = %d", num1, num2, (num1 - num2))
					: "잘못 입력했습니다";
		System.out.println(result);
		
		
		/* 코드 작성
		System.out.print(num1);
		int sum = num1 + num2;
		System.out.print(num1 + " + " + num2 + " = " + sum);
		
		sc.nextLine();
		
		System.out.print("연산자 입력(+ 또는 -) > ");
		char op1 = sc.nextLine().charAt(0);
		int sub =  num1 - num2;
		System.out.print(num1 + " - " + num2 + " = " + sub);


//		String result = (c != '+' || c != '-') ? "잘못 입력했습니다" : (c == '+' || c == '-') ? "+" : "-";
//		System.out.println(result);
		
		*/
	
	}
}