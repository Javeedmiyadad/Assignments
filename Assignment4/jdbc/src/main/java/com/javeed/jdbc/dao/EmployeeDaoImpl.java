package com.javeed.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.javeed.jdbc.entities.Employee;
import com.javeed.jdbc.entities.EmployeeRowMapper;

public class EmployeeDaoImpl implements EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addEmployee(Employee employee) {
		String str = "insert into employee(Id,Name,Role,Salary) values (?,?,?,?)";
		int res = jdbcTemplate.update(str, employee.getId(), employee.getName(), employee.getRole(),
				employee.getSalary());
		return res;

	}

	public void updateEmployee(Employee employee) {
		String str = "update employee set Name='" + employee.getName() + "', Role='" + employee.getRole()
				+ "', Salary='" + employee.getSalary() + "' where Id=" + employee.getId();
		jdbcTemplate.update(str);
	}

	public void deleteEmployee(int id) {
		String str = "delete from employee where Id = " + id;
		jdbcTemplate.update(str);

	}

	public List<Employee> getEmployee() {
		String str = "select * from employee ";
		EmployeeRowMapper emp = new EmployeeRowMapper();
		List<Employee> employees = jdbcTemplate.query(str, emp);
		return employees;
	}

	public Employee getEmployeeById(int id) {
		String str = "select * from employee where Id = ?";
		EmployeeRowMapper emp = new EmployeeRowMapper();
		Employee employee = jdbcTemplate.queryForObject(str, emp, id);

		return employee;
	}

}
