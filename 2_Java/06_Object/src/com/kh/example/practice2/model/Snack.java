package com.kh.example.practice2.model;

public class Snack {

	private String kind;
	private String name;
	private String flavor;
	private int numOf;
	private int price;
	
	// 오버로딩, 오버라이딩 구분
	// 결국 생성자도 메서드
	public Snack() { // 기본 생성자가 지정되어 있어야 호출이 가능
	}
	
	public Snack(String kind, String name, String flavor, int numOf, int price) {
		this.kind = kind;
		this.name = name;
		this.flavor = flavor;
		this.numOf = numOf;
		this.price = price;
	}
	
	// getter 데이터 가지고 올 때
	public String getKind() {
		return kind;
	}

	// setter 데이터 담아낼 때
	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getNumOf() {
		return numOf;
	}

	public void setNumOf(int numOf) {
		this.numOf = numOf;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	@Override
	public String toString() {
		return "Snack [kind=" + kind + ", name=" + name + ", flavor=" + flavor + ", numOf=" + numOf + ", price=" + price
				+ "]";
	}

	// 이거 없애버리면 Console에 output 주소값 형태로 나옴
	// 내가 입력한 값이 잘 담아져있나 체크하는 용도로 사용 toString()
//	public String toString() {
//		return kind + "(" + name + " - " + flavor
//				+ ") " + numOf + "개 " + price + "원";
//	}

}
