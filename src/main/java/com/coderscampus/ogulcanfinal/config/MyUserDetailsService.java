package com.coderscampus.ogulcanfinal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coderscampus.ogulcanfinal.domain.AuthenticatedUser;
import com.coderscampus.ogulcanfinal.domain.User;
import com.coderscampus.ogulcanfinal.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user  =userRepo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Username and/or password do not exist");
		}
		return new AuthenticatedUser(user);
	}

}
