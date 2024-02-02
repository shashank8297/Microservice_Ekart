package com.infinite.identity.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.infinite.identity.model.UserCredential;

public class CustomeUserDetails implements UserDetails {
	
	private String username;
	private String password;	

	public CustomeUserDetails(UserCredential userCredential) {
		
		System.out.println("S-02-1");
		
		this.username = userCredential.getName();
		System.out.println(userCredential.getName());
		
		this.password = userCredential.getPassword();
		System.out.println(userCredential.getPassword());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		System.out.println("S-02-2");
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		System.out.println("S-02-3");
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		System.out.println("S-02-4");
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		System.out.println("S-02-5");
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		System.out.println("S-02-6");
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		System.out.println("S-02-7");
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		System.out.println("S-02-8");
		return true;
	} 

}
