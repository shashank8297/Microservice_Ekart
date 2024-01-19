package com.infinite.useraccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.useraccount.model.User;
import com.infinite.useraccount.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired()
	UserService userService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public User findUserById(@PathVariable("id") Long userId) {
		return userService.findUserById(userId);
	}
	
	@PostMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") Long userId) {
		userService.removeUser(userId);
		String msg = "User Id : "+userId+" is deleted";
		return msg;
	}
}
