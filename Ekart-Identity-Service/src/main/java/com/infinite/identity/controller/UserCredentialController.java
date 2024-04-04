package com.infinite.identity.controller;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import com.infinite.identity.dto.AuthRequest;
import com.infinite.identity.model.UserCredential;
import com.infinite.identity.service.UserCredentialService;

@RestController
//@CrossOrigin("http://10.4.33.15:3000")
@RequestMapping("/auth")
public class UserCredentialController {

	@Autowired
	UserCredentialService userCredentialService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/registor")
	public String addNewUser(@RequestBody UserCredential userCredential) {
		System.out.println("T-01");
		System.out.println(userCredential.getEmail());
		System.out.println(userCredential.getName());
		System.out.println(userCredential.getPassword());
		return userCredentialService.saveUser(userCredential);
	}

	@PostMapping("/token")
	public String getTokent(@RequestBody AuthRequest authRequest) throws AuthenticationException {
		
		try {
			System.out.println("S-01");
			Authentication authenticate = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							authRequest.getUsername(),authRequest.getPassword()));
			if(authenticate.isAuthenticated()) {
				System.out.println("S-02");
				System.out.println(userCredentialService.generateToken(authRequest.getUsername()));
				return userCredentialService.generateToken(authRequest.getUsername());
			}
			else {
				String msg = "Invalid Credenrials";
				return msg;
			}
		}
		catch (BadCredentialsException | DisabledException e) {
			// TODO: handle exception
			throw new AuthenticationException("Authentication Failed",e);
			}	
	}
	
	@GetMapping("/validate/{token}")
	public String validateToken(@PathVariable ("token") String token) {
		
		System.out.println("T-01");
		
		userCredentialService.validteToken(token);

		System.out.println("T-02");
		return "token validate";
	}
	
	
	@PostMapping("/findId")
	public Long userId(@RequestBody AuthRequest authRequest) {
		
		return userCredentialService.findUserId(authRequest);
		
	}
	
	@GetMapping("/userDetails/{userId}")
	public UserCredential userDetails(@PathVariable ("userId") Long id) {
		System.out.println("u-1");
		return userCredentialService.userDetails(id);
	}
	
	@PutMapping("/updateEmail/{userId}")
	public String updateEmail(@PathVariable ("userId") Long id, @RequestBody UserCredential userCredential) {
		return userCredentialService.updateEmail(id, userCredential.getEmail());
	}
}
