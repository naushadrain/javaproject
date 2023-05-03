package com.bway.springdemo.service;

import java.util.List;

import com.bway.springdemo.model.Employee;

public interface IEmployeeService {
	
	void addEmp(Employee employee);
	
	void deleteEmp(int id);
	
	void updateEmp(Employee employee);
	
	Employee getEmpById(int id);
	
	List<Employee>  getAllEmps();

}
