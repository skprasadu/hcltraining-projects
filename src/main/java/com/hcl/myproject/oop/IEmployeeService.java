package com.hcl.myproject.oop;

public interface IEmployeeService {
	
	void insert(Employee emp);
	
	void update(Employee emp);
	
	Employee read(int id);
	
	void delete(int id);
}
