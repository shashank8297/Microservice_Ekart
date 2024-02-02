package com.infinite.identity.controller;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import com.infinite.identity.dto.AuthRequest;
import com.infinite.identity.model.UserCredential;
import com.infinite.identity.service.UserCredentialService;

@RestController
@RequestMapping("/auth")
public class UserCredentialController {

	@Autowired
	UserCredentialService userCredentialService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/registor")
	public String addNewUser(@RequestBody UserCredential userCredential) {
		System.out.println("T-01");
		return userCredentialService.saveUser(userCredential);
	}

	@PostMapping("/token")
	public String getTokent(@RequestBody AuthRequest authRequest) throws AuthenticationException {
		
		try {
			System.out.println("S-01");
			Authentication authenticate = authenticationManager.authenticate( new
					 UsernamePasswordAuthenticationToken(authRequest.getUsername(),
					 authRequest.getPassword()));
			if(authenticate.isAuthenticated()) {
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
}
