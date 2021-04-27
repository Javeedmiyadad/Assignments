package com.javeed.jdbc.entities;

public class Employee {
	private int id;
	private String name;
	private String role;
	private int Salary;

	public Employee() {

	}

	public Employee(int id, String name, String role, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		Salary = salary;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + role + ", Salary=" + Salary + "]";
	}

}
