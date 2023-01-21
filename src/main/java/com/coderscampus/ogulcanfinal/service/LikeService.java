package com.coderscampus.ogulcanfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.ogulcanfinal.domain.Like;
import com.coderscampus.ogulcanfinal.repository.LikeRepository;

@Service
public class LikeService {

	@Autowired
	private LikeRepository likeRepository;
	
	public Like findUserById(Long userId,Long movieId) {
		return likeRepository.findLikeByUserId(userId,movieId).get();
	}
	
	public void like(Long userId, Long movieId) {
		
		Like l = likeRepository.findLikeByUserId(userId,movieId).orElse(new Like());;
		System.out.println(l.getId());
		if(l.getMovieId() == null) {
			
		l.setUserId(userId);
		l.setMovieId(movieId);
		likeRepository.save(l);
		}
	}
	
	public void unlike(Long userId, Long movieId) {
		likeRepository.deleteByUserIdAndMovieId(userId,movieId);
	}
	
	public Long getNumberOfLikes(Long movieId) {
		return likeRepository.countByMovieId(movieId);
	}
}
