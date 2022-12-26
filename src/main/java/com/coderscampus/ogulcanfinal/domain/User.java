package com.coderscampus.ogulcanfinal.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String username;
	private String password;
	
	// Watch List
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "movie_user_watch", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private Set<Movie> watchList;

	@OneToMany(mappedBy = "user")
	
	private List<Comment> comments;
	
	// Watched Movies
	@OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Movie> watchedList;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "movie_user",
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private List<Movie> movies;
	public Long getId() {
		return userId;
	}

	public void setId(Long id) {
		this.userId = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public Set<Movie> getWatchList() {
		return watchList;
	}

	public void setWatchList(Set<Movie> watchList) {
		this.watchList = watchList;
	}
	

	public List<Movie> getWatchedList() {
		return watchedList;
	}

	public void setWatchedList(List<Movie> watchedList) {
		this.watchedList = watchedList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
