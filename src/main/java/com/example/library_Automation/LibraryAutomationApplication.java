package com.example.library_Automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LibraryAutomationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryAutomationApplication.class, args);
	}
}
