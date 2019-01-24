package com.movies.library.rest.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movies.library.business.controller.MoviesBusinessController;
import com.movies.library.dto.MovieDto;

@RestController
public class MovieRestController {

	@Autowired
	MoviesBusinessController business;

	@RequestMapping("/") // you can put "/home" here
	public String homePage() {
		return String.format("Hello this is the %s", "Home Page!");
	}

	@GetMapping("/search")
	public ResponseEntity<MovieDto> searchMovie(@RequestParam String title, @RequestParam(defaultValue = "") String year)
			throws IOException, ParseException {
		MovieDto movie = business.handleMovieRequest(title, year);
		return new ResponseEntity<MovieDto>(movie, HttpStatus.OK);
	}

	@GetMapping("/movies")
	public ResponseEntity<List<MovieDto>> showMovies() {
		List<MovieDto> moviesList = business.getAllMovie();
		if (moviesList != null && !moviesList.isEmpty()) {
			return new ResponseEntity<List<MovieDto>>(moviesList, HttpStatus.OK);
		}
		return new ResponseEntity<List<MovieDto>>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/movie")
	public ResponseEntity<MovieDto> showMovieByTitle(@RequestParam String movieTitle) {
		MovieDto movieDto = business.findMovieByTitle(movieTitle);
		if (movieDto != null) {
			return new ResponseEntity<MovieDto>(movieDto, HttpStatus.OK);
		}
		return new ResponseEntity<MovieDto>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/findByImdbId")
	public ResponseEntity<MovieDto> showMovieByImdbId(@RequestParam String imdbId) {
		MovieDto movieDto = business.findMoviebyImdbId(imdbId);
		if (movieDto != null) {
			return new ResponseEntity<MovieDto>(movieDto, HttpStatus.OK);
		}
		return new ResponseEntity<MovieDto>(HttpStatus.NOT_FOUND);
	}

}
