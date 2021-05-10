package com.javee.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javee.Employee.entity.Employee;
import com.javee.Employee.service.EmployeeService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	
	//create
	@PostMapping("/")
	public Employee save(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	//getbyid
	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}
	//delete
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		 service.delete(id);
	}
	//getall
	@GetMapping("/get")
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	//update
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable("id") Integer id,@RequestBody Employee emp) {
		return service.updateEmployee(id, emp);
	}
}


