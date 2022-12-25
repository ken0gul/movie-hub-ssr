package com.coderscampus.ogulcanfinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.ogulcanfinal.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
		
		@Query(value ="select * from comment c where movie_id=:movieId and user_id=:userId",nativeQuery = true )
		List<Comment> findCommentsByMovieIdAndUserId(Long movieId, Long userId);
		
//		List<Comment> findAllByMovieId(Long movieId);

}
