package com.hcl.myproject.oop;

public class EmployeeServiceFactory {

	static IEmployeeService getInstance(String environment) {

		return environment.equals("Dev") ? new AppEmployeeService() : new TestEmployeeService();

	}
}
