package com.vartalap.Sastrarth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class SastrarthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SastrarthApplication.class, args);
	}
	
	@GetMapping()
	public String welcome() {
		return "Welcome to my page";
	}

}
