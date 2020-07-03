package com.example.library_Automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LibraryAutomationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryAutomationApplication.class, args);
	}
}
