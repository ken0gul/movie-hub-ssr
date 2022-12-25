package com.coderscampus.ogulcanfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.ogulcanfinal.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findById(Long id);
}
