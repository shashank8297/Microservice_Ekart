package com.infinite.logs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("/newUser")
	public String newUser(@RequestBody User user) {
		
		userService.newUser(user);
		return "new user is added";
	}
	
	@GetMapping("/user/{id}")
	public User userDetails(@PathVariable("id") Long userId) {
	
		return userService.userDetails(userId);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public String userDelete(@PathVariable("id") Long userId) {
		boolean result =  userService.userDelete(userId);
		if(result) {
			return "user "+userId+" is deleted";
		}
		return ".";
	}
}
