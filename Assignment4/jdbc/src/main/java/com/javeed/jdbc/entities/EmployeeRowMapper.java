package com.javeed.jdbc.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt("Id"));
		employee.setName(rs.getString("Name"));
		employee.setRole(rs.getString("Role"));
		employee.setSalary(rs.getInt("Salary"));
		return employee;
	}

}
