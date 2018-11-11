package com.movies.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.library.entity.Movie;

import antlr.collections.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	public Movie findMovieByTitle(String title);
	public Movie findMovieByImdbId(String imdbId);
}
