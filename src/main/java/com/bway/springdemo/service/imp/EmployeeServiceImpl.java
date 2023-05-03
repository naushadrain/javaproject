package com.bway.springdemo.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springdemo.model.Employee;
import com.bway.springdemo.repository.EmployeeRepository;
import com.bway.springdemo.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public void addEmp(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	public void deleteEmp(int id) {
		 
		employeeRepo.deleteById(id);
	}

	@Override
	public void updateEmp(Employee employee) {
		 
		employeeRepo.save(employee);
	}

	
	@Override
	public Employee getEmpById(int id) {
		 
		return employeeRepo.getById(id);
	}

	@Override
	public List<Employee> getAllEmps() {
		 
		return employeeRepo.findAll();
	}

}
