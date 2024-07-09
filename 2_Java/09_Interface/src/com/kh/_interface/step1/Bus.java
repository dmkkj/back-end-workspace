package com.kh._interface.step1;

public class Bus implements Vehicle {
	// 해당하는 추상메서드들 구현(자동 완성)
	@Override
	public void run() {
		System.out.println("버스가 달린다.");
	}

	@Override
	public void turn() {
		System.out.println("버스가 돈다.");
	}
	
}
