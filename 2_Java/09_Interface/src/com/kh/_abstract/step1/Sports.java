package com.kh._abstract.step1;

public abstract class Sports {

	protected int numberOfPlayers; // 참여하는 사람 수

	public Sports(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	// 추상메서드 -> 자식 클래스에서 무조건 재정의 해주어야 한다!
//	public abstract void rule() {} -> 에러. abstract는 {} 구현 부분이 필요 없음
	public abstract void rule();
		
	
}
