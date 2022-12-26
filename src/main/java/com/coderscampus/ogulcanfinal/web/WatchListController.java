package com.coderscampus.ogulcanfinal.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.ogulcanfinal.domain.Movie;
import com.coderscampus.ogulcanfinal.domain.User;
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
		User user = userService.findById(userId);
		model.put("user", user);
		System.out.println(user);
		return "user";
	}

	@PostMapping("/user/{userId}")
	public String postToDo(Movie movie, @PathVariable Long userId) {

		User user = userService.findById(userId);
		System.out.println("Found User Post TO Do: " + user);
		Long movieId = movie.getId();
		Movie movieFound = movieService.findById(movieId);
		Set<Movie> watchList = user.getWatchList();
		watchList.add(movieFound);

		user.setWatchList(watchList);

		List<User> userList = new ArrayList<>();
		userList.add(user);
		movieFound.setUsers(userList);
		System.out.println("User" + user);
		userService.save(user);
		return "redirect:/user/{userId}";
	}
}
