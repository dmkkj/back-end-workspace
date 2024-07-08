package com.kh.array.practice1;

import java.util.Arrays;

import com.kh.array.practice1.model.Student;

public class Application {

	public static void main(String[] args) {
		//String[] arr = new String[5]; // String 자바가 제공하는 기본 클래스
		Student[] arr = new Student[5]; // Student 객체 타입의, 5개의 배열이 올 수 있는 공간을 만들었다
		
		arr[0] = new Student("박성철", "자바", 100);
		arr[1] = new Student("이진우", "디비", 95);
		arr[2] = new Student("이준용", "자바", 97);
		arr[3] = new Student("김경주", "화면", 98);
		arr[4] = new Student("김현호", "자바", 95);
		
		System.out.println(Arrays.toString(arr)); // 클래스의 초기값 null만 5개 들어가있음	// [null, null, null, null, null]
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println();
		
		for(Student student : arr) {
			System.out.println(student);
		}
	}

}
