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

	public static void main(String[] args) {
		
		/*
		// 내 코드. 중복도 제거 안 되고.. 내 번호는 정렬도 안 되고..
		int[] number = {4, 28, 35, 39, 44, 45};
		System.out.println("로또 번호 : " + Arrays.toString(number));		
		
		System.out.print("내 번호 : " );
		int[] arr = new int[6];
		int random = (int) (Math.random() * 45 + 1);
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 45 + 1);
			random += arr[i];

			System.out.println(arr[i]); // 각 요소 출력
		}
		*/
	
		/* 풀이 */
	
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		
		// 기존 로또 번호는 6개, 보너스 번호가 필요해서 1개 더 추가!
		while(lotto.size() < 7) { //for(int i = 0; i < 6; i++) { -> for문: 중복 제거 후 출력하기 때문에 i가 6개로 한정되어 있지 않을 수 있음
			
			// lotto.contains(); 포함되어 있는 것 
			int num = (int) (Math.random() * 45 + 1);
			if(!lotto.contains(num)) { // 포함되어 있지 않은 경우만
				lotto.add(num);
			}
		}
		
		// 0 ~ 6까지 범위 지정해서 로또 번호 6개 따로, 보너스 번호 따로!
		List<Integer> lottoList = lotto.subList(0, 6);
		int bonus = lotto.get(6);
		
		
		int count = 0;
		
		while(true) {
		
			count ++;
			
			ArrayList<Integer> myLotto = new ArrayList<>();
			
			while(myLotto.size() < 6) {
				int num = (int) (Math.random() * 45 + 1);
				if(!myLotto.contains(num)) {
					myLotto.add(num);
				}
			}
			
			System.out.println("로또 번호 : " + lottoList);
			System.out.println("내 번호 : " + myLotto);
			
			Collections.sort(lottoList);
			Collections.sort(myLotto);
			
			// 멈추는 조건! 로또 번호와 내 번호가 정확히 일치! 1등 당첨!
			if(lottoList.equals(myLotto)) {
				System.out.println("1등 당첨! 횟수 : " + count);
				break;
			}
			
			int match = 0;
			
			for(Integer num : lottoList) {
				if(myLotto.contains(num)) {
					match++;
				}
			}
			
			if(match == 5) {
				if(myLotto.contains(bonus)) {
					System.out.println("2등 당첨! 보너스 번호 : " + bonus + ", 횟수 : " + count);
					break;
				} else {
					System.out.println("3등 당첨! 횟수 : " + count);
					break;
				}
			} else if(match == 4) {
				System.out.println("4등 당첨! 횟수 : " + count);
				break;
			} else if(match == 3) {
				System.out.println("5등 당첨! 횟수 : " + count);
				break;
			}
			
		}
	
	}

}
//		Set<String> set = new TreeSet<>();
		
//		set.add();
//		set.add("구교환");
//		set.add("홍사빈");
//		set.add("이제훈"); // 중복 제거
//		set.add("이제훈");
		
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
		
//		int sum = 0;
//		for(int i = 0; i < .size(); i++) {
//			sum += list.get(i).getAge();
		
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