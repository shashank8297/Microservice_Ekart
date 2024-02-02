package com.infinite.identity.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.infinite.identity.model.UserCredential;
import com.infinite.identity.repository.UserCredentialRepository;

@Component
public class CustomDetailsService implements UserDetailsService {

	@Autowired
	private UserCredentialRepository userCredentialRepository;

	@Override
	public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("S-01-1");
		System.out.println(user_name);
		Optional<UserCredential> credential = userCredentialRepository.findByName(user_name);
		
		System.out.println("S-01-2");
		
		if(credential.isPresent()) {
			UserCredential userCred = credential.get();
			System.out.println("S-01-3");
			
			CustomeUserDetails cud = new CustomeUserDetails(userCred);
			System.out.println("S-01-3_1");
			//System.out.println(cud);
			
			System.out.println("S-01-3_2");
			
			return new CustomeUserDetails(userCred);
		}
		else {
			System.out.println("S-01-4");
			throw new UsernameNotFoundException("User not found with name: "+user_name);
		}
		
		
		

		/*
		 * return credential.map(CustomeUserDetails::new) .orElseThrow(() -> new
		 * UsernameNotFoundException("user not found with name :" + user_name));
		 */
	}

}
