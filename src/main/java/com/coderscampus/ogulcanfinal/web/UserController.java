package com.coderscampus.ogulcanfinal.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.ogulcanfinal.domain.Comment;
import com.coderscampus.ogulcanfinal.domain.Movie;
import com.coderscampus.ogulcanfinal.domain.User;
import com.coderscampus.ogulcanfinal.service.CommentService;
import com.coderscampus.ogulcanfinal.service.LikeService;
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
	
	@Autowired
	private LikeService likeService;

	@GetMapping("/movie/{movieId}/user/{userId}")
	public String getMovie(ModelMap model, @PathVariable Long movieId, @PathVariable Long userId, Model m) {
		// Let's load likes
		m.addAttribute("userId", userId);
		m.addAttribute("movieId", movieId);
		model.put("likes", likeService.getNumberOfLikes(movieId));
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User authenticatedUser = (User)authentication.getPrincipal();
		System.out.println("Auth User: " + authenticatedUser);
		System.out.println("User Id: " + userId);
		if(!authenticatedUser.getUserId().equals(userId)) {
			return "redirect:/login?logout";
		}
		Movie foundMovie = movieService.findById(movieId);
		model.put("movie", foundMovie);

//		CommentModel newComment = new CommentModel();
//		model.put("comment", newComment);

		Comment newComment = new Comment();
		model.put("comment", newComment);

		List<Comment> allComments = commentService.findAll(userId, movieId);
		List<Comment> comments = commentService.findByMovieIdAndUserId(movieId, userId);
		System.out.println(allComments);
		model.put("comments", comments);
		model.put("allComments", allComments);
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

	// Update
	@GetMapping("/movie/{movieId}/user/{userId}/edit")
	@ResponseBody
	public Comment getUpdateComment(@PathVariable Long userId, Comment comment) {
		System.out.println(comment.getCommentText());
		return comment;
	}

	@PostMapping("/movie/{movieId}/user/{userId}/edit")
	@ResponseBody
	public Comment updateComment(@RequestBody Comment comment, Movie movie, User user) {
		Comment foundComment = commentService.findById(comment.getId());
		commentService.deleteComment(foundComment);

		return comment;
	}
	

	
	

}
