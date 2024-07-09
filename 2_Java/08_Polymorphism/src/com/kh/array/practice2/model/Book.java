package com.kh.array.practice2.model;

public class Book {

	private String title;
	private boolean coupon;
	private int accessAge;
	
	
	
	
}





package com.kh.step5.model;

public class Book {
	
	/*

	 * */
	private String title;
	private int price;
	private double discountRate;
	private String author;
	
//	public Book() {} // 생성자
		
//	public Book(String title, int price, double discountRate, String author) { // 생성자
//		this.title = title;
//		this.price = price;
//		this.discountRate = discountRate;
//		this.author = author;
//	}
	
	/* Alt + Shift + S로 자동으로 생성자 만들기 */
	public Book() { // Alt + Shift + S >> Generate Constructors from SupperClass...
	}
	
	public Book(String title, int price, double discountRate, String author) {
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
	}
	
	// getter, setter
	// setter 값을 넣는 애들
	public void setTitle(String title) { // 원하는 값 하나만 담아내기
		this.title = title;
	}
	
	public String getTitle() { // 가지고 오는 역할
		return title;
	}

	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", discountRate=" + discountRate + ", author=" + author
				+ "]";
	}

//	public String toString() {
//		return "Book - title : " + title + ", price : " + price + " , discountRate : " + discountRate + ", author : " + author;
//	}
	
}
