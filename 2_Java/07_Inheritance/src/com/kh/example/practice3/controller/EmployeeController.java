package com.kh.example.practice3.controller;

import com.kh.example.practice3.model.Employee;

public class EmployeeController {

	private Employee employee = new Employee();
	
	// 메서드명은 똑같은데 따로 쓸 수 있는 이유 : 매개변수의 타입이 다른 경우 메서드명 동일하게 사용 가능
	// 오버로딩!! (메서드명은 같은데 매개변수가 다르거나, 개수가 같더라도 매개변수에 해당하는 파라미터 값이 다르거나!)
	public void add(int empNo, String name, char gender, String phone) {
		employee.setEmpNO(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
	}
	
	public void add(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		employee.setEmpNO(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
		employee.setDept(dept);
		employee.setSalary(salary);
		employee.setBonus(bonus);
	}

	public void modify(String phone) {
		employee.setPhone(phone);
	}
	
	public void modify(int Salary) {
		employee.setSalary(Salary);
	}
	
	public void modify(double bonus) {
		employee.setBonus(bonus);
	}
	
	public Employee info() {
		return employee;
	}
}
