package com.coderscampus.ogulcanfinal.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coderscampus.ogulcanfinal.domain.Comment;
import com.coderscampus.ogulcanfinal.domain.Movie;
import com.coderscampus.ogulcanfinal.domain.User;
import com.coderscampus.ogulcanfinal.service.CommentService;
import com.coderscampus.ogulcanfinal.service.MovieService;
import com.coderscampus.ogulcanfinal.service.UserService;

@Controller

public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CommentService commentService;

//	@GetMapping("/movie/{movieId}/user/{userId}")
//	public String getUser(@PathVariable Long userId, ModelMap model, @PathVariable Long movieId) {
//		User user = userService.findById(userId);
//		model.put("user", user);
//		
//		Movie foundMovie = movieService.findById(movieId);
//		model.put("movie", foundMovie);
//		return "user";
//	}
//	
	
	
	
	
	
	
	@GetMapping("/movie/{movieId}/user/{userId}")
	public String getMovie(ModelMap model,@PathVariable Long movieId, @PathVariable Long userId) {
		Movie foundMovie = movieService.findById(movieId);
		model.put("movie", foundMovie);
		
		
//		CommentModel newComment = new CommentModel();
//		model.put("comment", newComment);
		
		Comment newComment = new Comment();
		model.put("comment", newComment);

		
		List<Comment> allComments = commentService.findAll();
		List<Comment> comments = commentService.findByMovieIdAndUserId(movieId,userId);
//		List<Comment> commentsAll = commentService.findAllByMovieId(movieId);
		model.put("comments", comments);
		
		User user = userService.findById(userId);
		model.put("user", user);
	
		
		return "movie";
	}
	
	@PostMapping("/movie/{movieId}/user/{userId}")
	public String postComment(Comment newComment, Movie movie, User user) {
		System.out.println(movie);
		Comment comment = new Comment();
		comment.setUser(user);
		comment.setMovie(movie);
		comment.setCommentText(newComment.getCommentText());
		
		Comment savedComment = commentService.saveComment(comment);
		
		
		return "redirect:/movie/{movieId}/user/{userId}";
	}
}
