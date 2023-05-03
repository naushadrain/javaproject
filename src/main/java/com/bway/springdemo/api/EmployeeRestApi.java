package com.bway.springdemo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bway.springdemo.model.Employee;
import com.bway.springdemo.service.IEmployeeService;

@RestController
public class EmployeeRestApi {
	
	@Autowired
	private IEmployeeService  service;
	
	@GetMapping("/api/emp/list")
	public List<Employee> getAll() {
		
		return service.getAllEmps();
	}
	
	@PostMapping("/api/emp/add")
	public String add(@RequestBody Employee employee) {
		
		service.addEmp(employee);
		
		return "added success";
	}
	
	@PutMapping("/api/emp/update")
	public String update(@RequestBody Employee employee) {
		
		service.updateEmp(employee);
		
		return "update success";
	}
	
	@DeleteMapping("/api/emp/delete/{id}")
	public String delete(@PathVariable int id) {
		service.deleteEmp(id);
		return "delete success";
	}
	
	@GetMapping("/api/emp/{id}")
	public Employee getOne(@PathVariable int id) {
		
		return service.getEmpById(id);
	}

	@GetMapping("/api/emp/j2obj")
	public String jsonToObject() {
		
		RestTemplate   rest = new RestTemplate();
		Employee  emp = rest.getForObject("http://localhost/api/emp/4", Employee.class);
		
		return emp.getFname();
	}
	
	@GetMapping("/api/emp/jarray")
	public String josnArrayToObjArray() {
		
		RestTemplate   rest = new RestTemplate();
		Employee[]  emp = rest.getForObject("http://localhost/api/emp/list", Employee[].class);
		
		return emp[0].getFname(); 
		
	}
	
	
}
