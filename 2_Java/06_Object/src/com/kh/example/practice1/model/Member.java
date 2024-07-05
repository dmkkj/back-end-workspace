package com.kh.example.practice1.model;

public class Member {

	private String id; // private 같은 클래스 내에서만 접근 가능
	private String pwd;
	private String name;
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	public Member() {} // public 다른 패키지에 있는 다른 클래스에서도 사용 가능
	
	public void changeName(String name) {
		this.name = name; // --> 여기서는 this. 명시한 이유 : name = name;일 경우(String name)의 name값을 가지고 오기 때문(가장 가까운 name값 가져옴)  
	}
	
	public void printName() {
		System.out.println(name); // System.out.println(this.name); >> this. 생략되어있음
	}
	
	/*
	public Member(String id, String pwd, String name, int age, char gender, String phone, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	*/
	
}
