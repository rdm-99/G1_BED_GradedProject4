package com.greatlearning;

import org.springframework.boot.SpringApplication;
import com.greatlearning.controller.EmployeeController;
import org.springframework.context.annotation.Import;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Import({EmployeeController.class})

public class EmployeemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementApplication.class, args);
	}

}
