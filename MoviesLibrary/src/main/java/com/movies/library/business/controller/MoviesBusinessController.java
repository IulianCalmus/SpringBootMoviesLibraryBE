package com.movies.library.business.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movies.library.dto.MovieDto;
import com.movies.library.entity.Movie;
import com.movies.library.mapper.MovieMapper;
import com.movies.library.repository.MovieRepository;
import com.movies.library.service.MovieService;

@Service
public class MoviesBusinessController {

	@Autowired
	MovieService movieService;

	@Autowired
	MovieRepository movieRepository;
	
	public MovieDto handleMovieRequest (String movieTitle, String movieYear) throws ParseException, IOException {
		
		ResponseEntity<String> apiResponse = movieService.serveMovie(movieTitle, movieYear);
		return filterServiceResponse(apiResponse);
		
	}
	
	public MovieDto filterServiceResponse (ResponseEntity<String> serviceResponse) throws IOException, ParseException {
		Movie movie = new Movie();
		MovieMapper movieMapper = new MovieMapper();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode json = mapper.readTree(serviceResponse.getBody());
		System.out.println("Root " + json);//just for debugging purposes
		String response = json.path("Response").textValue();
		System.out.println("Response " + response);//just for debugging purposes
		if (!response.equalsIgnoreCase("false")) {
			movie = movieMapper.externalToMovie(json);
			temporarySaveMethod(movie);
			return movieMapper.fromTrueResponseToDto(json);
		}
		return movieMapper.fromFalseResponseToDto(json);
	}
	//this should be refactored
	private void temporarySaveMethod(Movie movie) {
		Movie movieFromDb = movieRepository.findMovieByImdbId(movie.getImdbId());
		System.out.println("to be saved " + movieFromDb);//just for debugging purposess
		if (movieFromDb == null) {
			movieRepository.save(movie);
		} else {
			movie.setId(movieFromDb.getId());
			movieRepository.save(movie);
		}
	}
	
	public List<MovieDto> getAllMovie() {
		MovieMapper movieMapper = new MovieMapper();
		List<Movie> movies = movieRepository.findAll();
		return movies.stream()
				.map(movieMapper::fromMovieToDto)
				.collect(Collectors.toList());
	}

	public MovieDto findMovieByTitle(String movieTitle) {
		MovieMapper movieMapper = new MovieMapper();
		return movieMapper.fromMovieToDto(movieRepository.findMovieByTitle(movieTitle));
	}

	public MovieDto findMoviebyImdbId(String imdbId) {
		MovieMapper movieMapper = new MovieMapper();
		return movieMapper.fromMovieToDto(movieRepository.findMovieByImdbId(imdbId));
	}
}
