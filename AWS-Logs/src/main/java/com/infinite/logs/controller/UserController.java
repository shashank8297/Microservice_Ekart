package com.infinite.logs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.logs.model.User;
import com.infinite.logs.service.UserService;



@RestController
@RequestMapping("/logs")
public class UserController {

	@Autowired
	private UserService userService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/newUser")
	public String newUser(@RequestBody User user) {
		
		userService.newUser(user);
		logger.info("new user is added");
		logger.info("userId: " +user.getUserId()+""
				+ "\n username: "+user.getUsename()+""
						+ "\n Email: "+user.getEmail());
		return "new user is added";
	}
	
	@GetMapping("/user/{id}")
	public User userDetails(@PathVariable("id") Long userId) {
		
		logger.info("Search for user with "+userId);
		
		return userService.userDetails(userId);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public String userDelete(@PathVariable("id") Long userId) {
		boolean result =  userService.userDelete(userId);
		if(result) {
			logger.info("User with userId "+userId+" is deleted.");
			return "user with "+userId+" is deleted";
		}
		return ".";
	}
	
	@GetMapping("/allUsers")
	public List<User> userList(){
		logger.info("getting users data");
		return userService.getAllUsers();
	}
}