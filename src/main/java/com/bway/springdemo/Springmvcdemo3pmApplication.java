package com.bway.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "EMS System",description = "Employee End points", version = "4.5.0"))
public class Springmvcdemo3pmApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springmvcdemo3pmApplication.class, args);
	}

}
