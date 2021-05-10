package com.javee.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javee.Employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Integer> {

	Employee findEmployeeById(Integer id);

}
