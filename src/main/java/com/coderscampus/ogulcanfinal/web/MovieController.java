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
import com.coderscampus.ogulcanfinal.domain.User;
import com.coderscampus.ogulcanfinal.service.CommentService;
import com.coderscampus.ogulcanfinal.service.MovieService;
import com.coderscampus.ogulcanfinal.service.UserService;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private UserService userService;

	@GetMapping("/movies")
	public String getMovies(ModelMap model) {
		List<Movie> allMovies = movieService.findAll();
		model.put("movies", allMovies);
		
		
		List<User> users = userService.findAll();
		
		for(User user : users) {
			
			model.put("user", user);
		}
		

		return "movies";
	}

	@PostMapping("/movies")
	@ResponseBody
	public Movie searchMovie(@RequestBody Movie movie, User user) {
		
		
		return movieService.saveMovie(movie);

	}


}
