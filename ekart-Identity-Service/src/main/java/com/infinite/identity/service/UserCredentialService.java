package com.infinite.identity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infinite.identity.dto.AuthRequest;
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


	
	public Long findUserId(AuthRequest authRequest) {
		// TODO Auto-generated method stub
		authRequest.setPassword(passwordEncoder.encode(authRequest.getPassword()));
		System.out.println(authRequest.getPassword());
		System.out.println(authRequest.getUsername());
		
		Optional<UserCredential> userCredential = userCredentialRepository.findByName(authRequest.getUsername());
		if(userCredential != null) {
			Long userId = userCredential.get().getUserId();
			System.out.println(userId);
			return userId;
			
		}
		else {
			return null;
		}
	}


	public UserCredential userDetails(Long id) {
		// TODO Auto-generated method stub
		return userCredentialRepository.findById(id).orElseThrow(IllegalArgumentException::new);
	}


	public String updateEmail(Long id, String email) {
		// TODO Auto-generated method stub
		UserCredential userDetails = userCredentialRepository.findById(id).orElse(null);
		if(userDetails != null) {
			//UserCredential.setEmail(email);
			userDetails.setEmail(email);
			userCredentialRepository.save(userDetails);
			return "Email Updated.";
		}
		return null;
		
	}
}
