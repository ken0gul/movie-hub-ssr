package com.coderscampus.ogulcanfinal.web;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.ogulcanfinal.domain.Movie;
import com.coderscampus.ogulcanfinal.domain.User;
import com.coderscampus.ogulcanfinal.service.MovieService;
import com.coderscampus.ogulcanfinal.service.UserService;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;

	
	@GetMapping("")
	public String rootPage() {
		return "redirect:/movies";
	}

	@GetMapping("/movies")
	public String getMovies(ModelMap model) {
		List<Movie> allMovies = movieService.findAll();
		Set<Movie> allUniqueMovies = allMovies.stream().collect(Collectors.toSet());
		model.put("movies", allUniqueMovies);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User authenticatedUser = (User)authentication.getPrincipal();
		
		
		if(authenticatedUser.getUserId() == null) {
			return "login";
		}
			

			model.put("user", authenticatedUser);
		

		return "movies";
	}

	@PostMapping("/movies")
	@ResponseBody
	public Movie searchMovie(@RequestBody Movie movie, User user) {

		return movieService.saveMovie(movie);

	}

}
