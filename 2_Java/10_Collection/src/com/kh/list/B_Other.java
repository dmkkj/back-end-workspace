package com.kh.list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class B_Other {

	/*
	 * Vector 
	 * - 동기화된(synchronized) 메서드로 구성 (개념은 스레드에서~)
	 * */
	public void method1() {
		Vector v = new Vector();
		v.add(0);
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		v.add(5);
		v.add(6);
		v.add(7);
		v.add(8);
		v.add(9);
		v.add(10);
		System.out.println(v); // [0, 1, 2]
		System.out.println("size : " + v.size()); // 3
		System.out.println("capacity : " + v.capacity()); // 10
		
		v.trimToSize(); // capacity 크기 맞춰줌
		
		System.out.println("size : " + v.size());
		System.out.println("capacity : " + v.capacity());
	}
	
	// 스택(Stack) : 마지막에 저장한 것을 제일 먼저 꺼내는 LIFO(Last In First Out) 구조
	public void method2() {
		Stack s = new Stack();
		s.push(0); // 데이터 넣기
		s.push(1);
		s.push(2);
		s.push(3); 
		s.pop(); // 데이터 빼기
		s.push(4);
		s.pop();
		s.push(5);
		s.push(6);
		s.push(7);
		s.pop();
		System.out.println(s); // [0, 1, 2, 5, 6]
	}
	
	// 큐(Queue) : 처음에 저장한 것을 제일 먼저 꺼내는 FIFO(First In First Out) 구조
	public void method3() {
		
		// 큐는 인터페이스. 객체 생성 불가
		Queue q = new LinkedList();
		
		q.offer(0); // 데이터 넣기
		q.offer(1);
		q.offer(2);
		q.offer(3); 
		q.poll(); // 데이터 빼기
		q.add(4);
		q.remove();
		q.add(5);
		q.add(6);
		q.add(7);
		q.remove();
		System.out.println(q); // [3, 4, 5, 6, 7]
	}
	
	public static void main(String[] args) {
		B_Other b = new B_Other();
//		b.method1();
//		b.method2();
		b.method3();
	}

}
