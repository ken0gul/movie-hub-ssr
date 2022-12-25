package com.coderscampus.ogulcanfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.ogulcanfinal.domain.Comment;
import com.coderscampus.ogulcanfinal.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public List<Comment> findAll(){
		return commentRepository.findAll();
	}
	
	public List<Comment> findByMovieId(Long movieId) {
		return commentRepository.findCommentsByMovieId(movieId);
	}
}