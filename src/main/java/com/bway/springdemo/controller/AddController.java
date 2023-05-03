package com.bway.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddController {
	
	@GetMapping("/add")
	public String getInputForm() {
		
		return "Input";
	}

	@PostMapping("/add")
	public String addition(@RequestParam int a, @RequestParam int b, Model model) {
		
		int s = a + b;
		model.addAttribute("sum",s);
		
		return "Result";
	}
	
	
	
}
