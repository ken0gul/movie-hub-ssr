package com.coderscampus.ogulcanfinal.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.ogulcanfinal.domain.Movie;
import com.coderscampus.ogulcanfinal.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	
	@GetMapping("/movies")
	public String getMovies(ModelMap model) {
		List<Movie> allMovies = movieService.findAll();
		model.put("movies", allMovies);
		return "movies";
	}

	@PostMapping("/movies")
	@ResponseBody
	public Movie searchMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
		
	}
	
	
	@GetMapping("/movie/{id}")
	public String getMovie(ModelMap model,@PathVariable Long id) {
		Movie foundMovie = movieService.findById(id);
		model.put("movie", foundMovie);
		System.out.println(foundMovie);
		return "movie";
	}
}
