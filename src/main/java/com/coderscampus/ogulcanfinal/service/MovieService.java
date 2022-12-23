package com.coderscampus.ogulcanfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.ogulcanfinal.domain.Movie;
import com.coderscampus.ogulcanfinal.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
	
	
	public Movie findById(Long id) {
		return movieRepository.findById(id).orElse(null);
	}
}
