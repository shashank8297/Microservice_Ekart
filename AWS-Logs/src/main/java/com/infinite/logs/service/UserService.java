package com.infinite.logs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.logs.model.User;
import com.infinite.logs.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void newUser(User user) {
		userRepository.save(user);
	}

	public User userDetails(Long userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).get();
	}

	public boolean userDelete(Long userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
		return true;
	}
}
