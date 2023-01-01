package com.coderscampus.ogulcanfinal.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.ogulcanfinal.domain.Movie;
import com.coderscampus.ogulcanfinal.domain.User;
import com.coderscampus.ogulcanfinal.model.WatchedMovie;
import com.coderscampus.ogulcanfinal.repository.UserRepository;
import com.coderscampus.ogulcanfinal.service.MovieService;
import com.coderscampus.ogulcanfinal.service.UserService;

@Controller

public class WatchListController {

	@Autowired
	private UserService userService;

	@Autowired
	private MovieService movieService;

	@GetMapping("/user/{userId}")
	public String getUser(@PathVariable Long userId, ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User authenticatedUser = (User)authentication.getPrincipal();
		
		if(!authenticatedUser.getUserId().equals(userId)) {
			return "redirect:/login?logout";
		}
		User user = userService.findById(userId);
		model.put("user", user);
		List<Movie> watchedMovies = user.getWatchedList();
		watchedMovies.forEach(System.out::println);
		model.put("movies", watchedMovies);
		return "user";
	}

	@PostMapping("/user/{userId}")
	public String postToDo(Movie movie, @PathVariable Long userId) {

		User user = userService.findById(userId);
		Long movieId = movie.getId();
		Movie movieFound = movieService.findById(movieId);
		Set<Movie> watchList = user.getWatchList();
		watchList.add(movieFound);

		user.setWatchList(watchList);

		List<User> userList = new ArrayList<>();
		userList.add(user);
		movieFound.setUsers(userList);
		userService.save(user);
		movieService.saveMovie(movieFound);
		return "redirect:/user/{userId}";
	}
	
	// Watched
	@GetMapping("/user/{userId}/delete")
	public String getWatched(@PathVariable Long userId, ModelMap model) {
		User user = userService.findById(userId);
		System.out.println(user);
		model.put("user", user);
		
		
		return "user";
	}
	
	
	
	@PostMapping("/user/{userId}/delete")
	@ResponseBody
	public WatchedMovie markAsWatched(@RequestBody WatchedMovie movie, @PathVariable Long userId) {
		User user = userService.findById(userId);
		System.out.println("Movie Id: " + movie.getMovieId());
		System.out.println(user);
		Movie foundMovie = movieService.findById(movie.getMovieId());
		List<Movie> watchedList = new ArrayList<>();
		foundMovie.setUser(user);
		watchedList.add(foundMovie);
		user.setWatchedList(watchedList);
		
		userService.save(user);
		movieService.saveMovie(foundMovie);
		userService.deleteMovieByMovieIdFromMovieUserWatch(movie.getMovieId());
		return movie;
	}
	
	
}
