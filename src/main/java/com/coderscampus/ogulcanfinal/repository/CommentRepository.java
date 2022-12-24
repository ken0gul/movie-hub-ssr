package com.coderscampus.ogulcanfinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.ogulcanfinal.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
		
		@Query(value ="select * from comments c where c.movie_id=:movieId",nativeQuery = true )
		List<Comment> findCommentsByMovieId(Long movieId);
}
