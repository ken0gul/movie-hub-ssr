package com.coderscampus.ogulcanfinal.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "all_movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movieId;
	
	@JsonProperty("Title")
	private String title;
	@JsonProperty("Year")
	private String Year;
	@JsonProperty("Rated")
	private String Rated;
	@JsonProperty("Relesead")
	private String Released;
	@JsonProperty("Runtime")
	private String Runtime;
	private String Genre;
	private String Director;
	private String Writer;
	@JsonProperty("Actors")
	private String Actors;
	@JsonProperty("Plot")
	private String Plot;
	@JsonProperty("Language")
	private String Language;
	private String Country;
	private String Awards;
	@JsonProperty("Poster")
	private String poster;
	private Rating[] Ratings;
	private String Metascore;
	private String imdbRating;
	private String imdbID;
	private String imdbVotes;
	private String Type;
	private String DVD;
	private String BoxOffice;
	private String Production;
	private String Website;
	private String Response;
	
	
	
	// OneToMany Movie-Comments
	@OneToMany(mappedBy = "movie")
	private List<Comment> comment;
	
	public Long getId() {
		return movieId;
	}
	public void setId(Long id) {
		this.movieId = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getRated() {
		return Rated;
	}
	public void setRated(String rated) {
		Rated = rated;
	}
	public String getReleased() {
		return Released;
	}
	public void setReleased(String released) {
		Released = released;
	}
	public String getRuntime() {
		return Runtime;
	}
	public void setRuntime(String runtime) {
		Runtime = runtime;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public String getActors() {
		return Actors;
	}
	public void setActors(String actors) {
		Actors = actors;
	}
	public String getPlot() {
		return Plot;
	}
	public void setPlot(String plot) {
		Plot = plot;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getAwards() {
		return Awards;
	}
	public void setAwards(String awards) {
		Awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public Rating[] getRatings() {
		return Ratings;
	}
	public void setRatings(Rating[] ratings) {
		Ratings = ratings;
	}
	public String getMetascore() {
		return Metascore;
	}
	public void setMetascore(String metascore) {
		Metascore = metascore;
	}
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getDVD() {
		return DVD;
	}
	public void setDVD(String dVD) {
		DVD = dVD;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getBoxOffice() {
		return BoxOffice;
	}
	public void setBoxOffice(String boxOffice) {
		BoxOffice = boxOffice;
	}
	public String getProduction() {
		return Production;
	}
	public void setProduction(String production) {
		Production = production;
	}
	public String getWebsite() {
		return Website;
	}
	public void setWebsite(String website) {
		Website = website;
	}
	public String getResponse() {
		return Response;
	}
	public void setResponse(String response) {
		Response = response;
	}
	
	
	
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", Year=" + Year + ", Rated=" + Rated + ", Released="
				+ Released + ", Runtime=" + Runtime + ", Genre=" + Genre + ", Director=" + Director + ", Writer="
				+ Writer + ", Actors=" + Actors + ", Plot=" + Plot + ", Language=" + Language + ", Country=" + Country
				+ ", Awards=" + Awards + ", poster=" + poster + ", Ratings=" + Arrays.toString(Ratings) + ", Metascore="
				+ Metascore + ", imdbRating=" + imdbRating + ", imdbID=" + imdbID + ", imdbVotes=" + imdbVotes
				+ ", Type=" + Type + ", DVD=" + DVD + ", BoxOffice=" + BoxOffice + ", Production=" + Production
				+ ", Website=" + Website + ", Response=" + Response + ", comment=" + comment + "]";
	}

	
	
	
	
	
	
}
