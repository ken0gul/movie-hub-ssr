package com.coderscampus.ogulcanfinal.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.ogulcanfinal.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findById(Long id);
	@Modifying
	@Transactional
	@Query(value="delete from movie_user_watch m where m.movie_id=:movieId",nativeQuery = true)
	 void deleteMovieByMovieIdFromMovieUserWatch(Long movieId);
	
	User findByUsername(String username);
}
