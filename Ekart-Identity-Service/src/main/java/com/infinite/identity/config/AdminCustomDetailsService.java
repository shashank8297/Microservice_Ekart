package com.infinite.identity.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.infinite.identity.model.Admin;
//import com.infinite.identity.model.UserCredential;
import com.infinite.identity.repository.AdminRepository;
//import com.infinite.identity.repository.UserCredentialRepository;

@Component
public class AdminCustomDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		Optional<Admin> admin = adminRepository.findByName(username);

		if (admin.isPresent()) {
			Admin admincred = admin.get();

			AdminCustomeDetails cudA = new AdminCustomeDetails(admincred);
			return new AdminCustomeDetails(admincred);
		} else {
			System.out.println("S-01-4");
			throw new UsernameNotFoundException("User not found with name: " + username);
		}
	}

}
