package com.javee.Employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javee.Employee.entity.Employee;
import com.javee.Employee.repository.EmployeeRepository;



@Service
public class EmployeeService {
	
@Autowired
private EmployeeRepository repository;

	
 public Employee saveEmployee(Employee employee) {
	 return repository.save(employee);
 }
 public Employee findById(Integer id) {
	 return repository.findEmployeeById(id);
 }
 public void delete(Integer id) {
	 repository.deleteById(id);
 }
 public List<Employee> getAllEmployees() {
	 return repository.findAll();
 }
 public Employee updateEmployee(Integer id,Employee emp) {
	 Employee employee = repository.findEmployeeById(id);
	 employee.setName(emp.getName());
	 employee.setEmail(emp.getEmail());
	 Employee update = repository.save(employee);
	 return update;
 }

}

