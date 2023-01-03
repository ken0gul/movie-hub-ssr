package com.coderscampus.ogulcanfinal.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.ogulcanfinal.domain.Movie;
import com.coderscampus.ogulcanfinal.domain.User;
import com.coderscampus.ogulcanfinal.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User findById(Long id) {
		return userRepository.findById(id).orElse(new User());
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
//	public Set<Movie> findAllByUserId(Long userId) {
//		return userRepository.findAllByUserId(userId);
//	}
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public void deleteMovieByMovieIdFromMovieUserWatch(Long movieId) {
		userRepository.deleteMovieByMovieIdFromMovieUserWatch(movieId);
	}
}
