package com.javeed.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.javeed.jdbc.dao.EmployeeDaoImpl;
import com.javeed.jdbc.entities.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			ApplicationContext context = new ClassPathXmlApplicationContext("Config4.xml");
			EmployeeDaoImpl emp = context.getBean("empDao", EmployeeDaoImpl.class);
			System.out.println("please select any options");
			System.out.println("************************");
			System.out.println("press 1 : Insert ");
			System.out.println("press 2 : update ");
			System.out.println("press 3 : delete ");
			System.out.println("press 4 : get ");
			System.out.println("press 5 : get by id ");
			System.out.println("************************");
			try {
				int option = sc.nextInt();
				switch (option) {
				case 1: {
					System.out.println("Enter Id :");
					int id = sc.nextInt();

					System.out.println("Enter Name :");
					String name = sc.next();

					System.out.println("Enter Role :");
					String role = sc.next();

					System.out.println("Enter Salary :");
					int salary = sc.nextInt();

					Employee employee = new Employee(id, name, role, salary);
					int res = emp.addEmployee(employee);
					System.out.println("(" + res + ") rows inserted");
					break;
				}
				case 2: {
					System.out.println("Enter Id :");
					int id = sc.nextInt();

					System.out.println("Enter Name :");
					String name = sc.next();

					System.out.println("Enter Role :");
					String role = sc.next();

					System.out.println("Enter Salary :");
					int salary = sc.nextInt();

					Employee employee = new Employee(id, name, role, salary);
					emp.updateEmployee(employee);
					System.out.println("Employee updated successfully");
					break;
				}
				case 3: {
					System.out.println("Enter the Id to be delete : ");
					int id = sc.nextInt();
					emp.deleteEmployee(id);
					System.out.println("Employee deleted successfully");
					break;
				}
				case 4: {
					List<Employee> employees = emp.getEmployee();
					for (Employee employee : employees) {
						System.out.println(employee.toString());
					}
					break;
				}
				case 5: {
					System.out.println("Enter the Id : ");
					int id = sc.nextInt();
					Employee employee = emp.getEmployeeById(id);
					System.out.println(employee.toString());
				}
				case 6: {
					flag = false;
					System.out.println("Thank you");
					return;
				}

				default: {
					System.out.println("please select any one");
				}

				}
			} catch (Exception ex) {
				System.out.println("Invalid option");
			}
		}
	}
}
