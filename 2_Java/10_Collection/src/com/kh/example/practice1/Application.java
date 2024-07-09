package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.kh.list.model.Person;

public class Application {

	public void method1() {

		while() {
		int[] number = {4, 28, 35, 39, 44, 45};
		System.out.println("로또 번호 : " + Arrays.toString(number));		
		
		int[] arr = new int[6];
		int random = (int) (Math.random() * 45 + 1);
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 45 + 1);
			random += arr[i];

			System.out.println(arr[i]); // 각 요소 출력
		}
		
		Set<String> set = new TreeSet<>();
		
		set.add();
		set.add("구교환");
		set.add("홍사빈");
		set.add("이제훈"); // 중복 제거
		set.add("이제훈");
		
		//System.out.print("내 번호 : " + arr[i]);
//		
//			count ++;
//			System.out.print("내 번호 : " + random);
//			if(random > num) {
//				System.out.println("더 큰 수를 입력하세요.");
//			} else if(random < num) {
//				System.out.println("더 작은 수를 입력하세요.");
//			}
//		}
		
//	public void method3() {
//		Scanner sc = new Scanner(System.in);
//		double[] arr = new double[3];
//		double sum = 0;
//		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.print("키 입력 > ");
//			arr[i] = sc.nextDouble();
//			// System.out.println(arr[i]);
//			sum += arr[i];
//		}
//		
//		System.out.printf("%.1f", sum / arr.length);
//		// System.out.println(Arrays.toString(arr)); // 입력한 값 배열에 저장
//	}
		
//		ArrayList<Number> list = new ArrayList<Number>();
//		System.out.println(number);
//		
//		list.add(new Number(4, 28, 35, 39, 44, 45));
//		// 1. add : 리스트 끝에 추가
//		list.add(new Person("전현무", "삼성동", 46)); 
	
		
//		System.out.println(list);
		
		
//		int sum = 0;
//		for(int i = 0; i < .size(); i++) {
//			sum += list.get(i).getAge();
//		
			
		
		
//		 0 <= Math.random() < 1
//		int random = (int) (Math.random() * 100 + 1);
//		
//		int num = 0;
//		int count = 0;
//		while(random != num) {
//			count ++;
//			System.out.print("1과 100 사이의 값 입력 > ");
//			num = sc.nextInt();
//			if(random > num) {
//				System.out.println("더 큰 수를 입력하세요.");
//			} else if(random < num) {
//				System.out.println("더 작은 수를 입력하세요.");
//			}
//		}
//		System.out.println(count + "번 만에 맞혔습니다.");
}
	
	public static void main(String[] args) {
		Application a = new Application();
		a.method1();
	}

}
