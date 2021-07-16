package com.samvedah.Aalay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AalayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AalayApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String HelloFriend() {
		return "Hello Friends";
	}

}
