package com.vartalap.Sastrarth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vartalap.Sastrarth.model.User;
import com.vartalap.Sastrarth.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User create(User user) {
		return userRepository.saveAndFlush(user);
	}
	
	public User getUser(Long id) {
		return userRepository.getById(id);
	}

}
