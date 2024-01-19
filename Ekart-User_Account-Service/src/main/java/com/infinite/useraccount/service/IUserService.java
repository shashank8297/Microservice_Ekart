package com.infinite.useraccount.service;

import com.infinite.useraccount.model.User;


public interface IUserService {

	public User saveUser(User user);
	
	//public List<> displayUser(User user);
	
	public User findUserById(Long userId); 
	
	public void removeUser(Long userId);
	
}
