package com.infinite.identity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infinite.identity.model.UserCredential;
import com.infinite.identity.repository.UserCredentialRepository;

@Service
public class UserCredentialService {

	@Autowired
	private UserCredentialRepository userCredentialRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	public String saveUser(UserCredential creddentials) {
		creddentials.setPassword(passwordEncoder.encode(creddentials.getPassword()));
		userCredentialRepository.save(creddentials);
		return "Successfull";
	}
	
	
	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}
	
	public void validteToken(String token) {
		jwtService.validateToken(token);
	}
}
