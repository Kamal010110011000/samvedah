package com.vartalap.Sastrarth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vartalap.Sastrarth.model.User;
import com.vartalap.Sastrarth.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping() 
	public ResponseEntity<User> createUser(@RequestBody User user){ 
		User savedUser =  userService.create(user);
		return ResponseEntity.accepted().body(savedUser);
	}
	
	@GetMapping()
	public ResponseEntity<User> getUser(@RequestParam Long id){
		User user = userService.getUser(id);
		return ResponseEntity.ok(user);
	}
	
}
