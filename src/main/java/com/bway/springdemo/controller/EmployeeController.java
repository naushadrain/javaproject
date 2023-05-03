package com.bway.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springdemo.model.Employee;
import com.bway.springdemo.repository.EmployeeRepository;
import com.bway.springdemo.service.IEmployeeService;
import com.bway.springdemo.service.imp.EmployeeServiceImpl;


@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService  service;
	
	//@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@GetMapping("/employee")
	public String get() {
		
		return "EmployeeForm";
	}
	
	@PostMapping("/employee")
	public String post(@ModelAttribute Employee  employee) {
		
		service.addEmp(employee);
		
		return "EmployeeForm";
	}

	@GetMapping("/emplist")
	public String listEmployee(Model model) {
		
		model.addAttribute("empList", service.getAllEmps());
		
		return "EmployeeList";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		
		service.deleteEmp(id);
		
		return "redirect:/emplist";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int id, Model model) {
		
		model.addAttribute("emodel", service.getEmpById(id));
		
		return "EditForm";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Employee employee) {
		
		service.updateEmp(employee);
		
	  return "redirect:/emplist";
	}
	
}




