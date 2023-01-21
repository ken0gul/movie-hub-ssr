package com.coderscampus.ogulcanfinal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.ogulcanfinal.service.LikeService;

@RestController
public class LikeController {

	
	@Autowired
	private LikeService likeService;
	
	

	
	
	@PostMapping("/movie/{movieId}/user/{userId}/like")
	public ResponseEntity<Long>like(@PathVariable Long movieId, @PathVariable Long userId, ModelMap model){

		model.put("likes", likeService.getNumberOfLikes(movieId));
		likeService.like(userId, movieId);
		Long numberOfLikes = likeService.getNumberOfLikes(movieId);
		System.out.println(numberOfLikes);
		return ResponseEntity.ok(numberOfLikes);
	
		
		
	}
	@PostMapping("/movie/{movieId}/user/{userId}/unlike")
	public ResponseEntity<Long>unlike(@PathVariable Long movieId, @PathVariable Long userId){

			
		likeService.unlike(userId, movieId);
		Long numberOfLikes = likeService.getNumberOfLikes(movieId);
		return ResponseEntity.ok(numberOfLikes);
	
		
		
	}
}
