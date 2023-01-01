package com.coderscampus.ogulcanfinal.domain;

import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticatedUser extends User implements UserDetails {

	
	
	private static final long serialVersionUID = 1L;

	public AuthenticatedUser(User user) {
		this.setUserId(user.getUserId());
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setAuthorities(user.getAuthorities());
		
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


}
