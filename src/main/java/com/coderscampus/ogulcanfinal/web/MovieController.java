package com.coderscampus.ogulcanfinal.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.ogulcanfinal.domain.Comment;
import com.coderscampus.ogulcanfinal.domain.Movie;
import com.coderscampus.ogulcanfinal.model.CommentModel;
import com.coderscampus.ogulcanfinal.service.CommentService;
import com.coderscampus.ogulcanfinal.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CommentService commentService;
	
	
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
		
		
//		CommentModel newComment = new CommentModel();
//		model.put("comment", newComment);
		
		Comment newComment = new Comment();
		model.put("comment", newComment);

		
		List<Comment> allComments = commentService.findAll();
		List<Comment> comments = commentService.findByMovieId(id);
		model.put("comments", comments);
		
		return "movie";
	}
	
	@PostMapping("/movie/{id}")
	public String postComment(Comment newComment, Movie movie) {
		System.out.println(movie);
		Comment comment = new Comment();
		comment.setMovie(movie);
		comment.setCommentText(newComment.getCommentText());
		
		Comment savedComment = commentService.saveComment(comment);
		
		
		return "redirect:/movie/{id}";
	}
	
}
