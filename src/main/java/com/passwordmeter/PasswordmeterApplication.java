package com.passwordmeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.passwordmeter")
public class PasswordmeterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordmeterApplication.class, args);
	}
}
