package com.coderscampus.ogulcanfinal.service;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public Comment findById(Long id) {
		return commentRepository.findById(id).get();
	}
	
	public List<Comment> findAll( Long userId, Long movieId){
		return commentRepository.findAll();
	}
	
	public List<Comment> findByMovieIdAndUserId(Long movieId, Long userId) {
		return commentRepository.findCommentsByMovieIdAndUserId(movieId,userId);
	}
	
//	public List<Comment> findAllByMovieId(Long movieId){
//		return commentRepository.findAllByMovieId(movieId);
//	}
	
	public void deleteComment(Comment comment) {
		commentRepository.delete(comment);
	}
}
