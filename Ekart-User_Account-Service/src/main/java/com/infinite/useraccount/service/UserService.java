package com.infinite.useraccount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.useraccount.model.User;
import com.infinite.useraccount.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public User findUserById(Long userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
	}

	public void removeUser(Long userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}
	
	
}
