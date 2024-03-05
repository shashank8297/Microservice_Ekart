package com.infinite.identity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infinite.identity.model.Admin;
import com.infinite.identity.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;

	public String addNewAdmin(Admin admin) {
		// TODO Auto-generated method stub
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		adminRepository.save(admin);
		return "Admin Added";
	}

	public String generateToken(String adminusername) {
		// TODO Auto-generated method stub
		return jwtService.generateToken(adminusername);
	}

	public void validateToken(String token) {
		// TODO Auto-generated method stub
		jwtService.validateToken(token);
	}
	
	
}
