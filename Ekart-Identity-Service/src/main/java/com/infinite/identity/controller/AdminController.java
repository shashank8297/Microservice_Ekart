package com.infinite.identity.controller;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.identity.dto.AdminRequest;
import com.infinite.identity.model.Admin;
import com.infinite.identity.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AdminService adminService;

	@PostMapping("/registor")
	public String addNewAdmin(@RequestBody Admin admin) {
		System.out.println("A-1");
		return adminService.addNewAdmin(admin);
	}

	@PostMapping("/token")
	public String getToken(@RequestBody AdminRequest adminRequest) throws AuthenticationException {
		try {
			System.out.println("AT-1");
			Authentication authentication = authenticationManager.authenticate(new 
					UsernamePasswordAuthenticationToken(
					adminRequest.getUsername(), adminRequest.getPassword()));
			System.out.println("AT-2");
			if (authentication.isAuthenticated()) {
				return adminService.generateToken(adminRequest.getUsername());
			} else {
				String msg = "Invalid Cred";
				return msg;
			}
		} catch (BadCredentialsException | DisabledException e) {
			// TODO: handle exception
			throw new AuthenticationException("Authentication Failed", e);
		}
		
		
	}
	@GetMapping("/validate/{token}")
	public String validateToken(@PathVariable ("token") String token) {
		adminService.validateToken(token);
		return "token validate";
	}

}
