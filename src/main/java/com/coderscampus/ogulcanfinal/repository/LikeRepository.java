package com.coderscampus.ogulcanfinal.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.coderscampus.ogulcanfinal.domain.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {
	
	@Modifying
	@Transactional
	void deleteByUserIdAndMovieId(Long userId, Long movieId);
	
	@Query(value = "select * from likes l where l.user_id=:userId and l.movie_id=:movieId",nativeQuery = true)
	Optional<Like> findLikeByUserId(Long userId, Long movieId);

	Long countByMovieId(Long movieId);

}
