package com.javeed.jdbc.dao;

import java.util.List;

import com.javeed.jdbc.entities.Employee;

public interface EmployeeDao {
	public int addEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(int id);

	public Employee getEmployeeById(int id);

	public List<Employee> getEmployee();

}
