package com.movies.library.mapper;

import java.text.ParseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.movies.library.dto.MovieDto;
import com.movies.library.entity.Movie;

public class MovieMapper {

	public Movie externalToMovie(JsonNode externalJson) throws ParseException {
		Movie movie = new Movie();

		movie.setTitle(externalJson.get("Title").asText());
		movie.setReleaseDate(externalJson.get("Released").asText());
		movie.setRuntime(externalJson.get("Runtime").asText());
		movie.setGenre(externalJson.get("Genre").asText());
		movie.setDirector(externalJson.get("Director").asText());
		movie.setWriter(externalJson.get("Writer").asText());
		movie.setActors(externalJson.get("Actors").asText());
		movie.setPlot(externalJson.get("Plot").asText());
		movie.setPoster(externalJson.get("Poster").asText());
		movie.setImdbRating(externalJson.get("imdbRating").asText());
		movie.setImdbId(externalJson.get("imdbID").asText());
		movie.setType(externalJson.get("Type").asText());
		movie.setBoxOffice(movie.getType().equalsIgnoreCase("movie") ? externalJson.get("BoxOffice").asText() : "N/A");
		movie.setProduction(movie.getType().equalsIgnoreCase("movie") ? externalJson.get("Production").asText(): "N/A");
		movie.setWebsite(movie.getType().equalsIgnoreCase("movie") ?externalJson.get("Website").asText() : "N/A");
		movie.setResponse(externalJson.get("Response").asText());
		movie.setMovieSeen(false);

		return movie;
	}

	public MovieDto fromTrueResponseToDto(JsonNode externalJson) throws ParseException {

		MovieDto movieDto = new MovieDto();
		movieDto.title = externalJson.get("Title").asText();
		movieDto.releaseDate = externalJson.get("Released").asText();
		movieDto.runtime = externalJson.get("Runtime").asText();
		movieDto.genre = externalJson.get("Genre").asText();
		movieDto.director = externalJson.get("Director").asText();
		movieDto.writer = externalJson.get("Writer").asText();
		movieDto.actors = externalJson.get("Actors").asText();
		movieDto.plot = externalJson.get("Plot").asText();
		movieDto.poster = externalJson.get("Poster").asText();
		movieDto.imdbRating = externalJson.get("imdbRating").asText();
		movieDto.imdbId = externalJson.get("imdbID").asText();
		movieDto.type = externalJson.get("Type").asText();
		movieDto.boxOffice = movieDto.type.equalsIgnoreCase("movie") ? externalJson.get("BoxOffice").asText() : "N/A";
		movieDto.production = movieDto.type.equalsIgnoreCase("movie") ? externalJson.get("Production").asText(): "N/A";
		movieDto.website = movieDto.type.equalsIgnoreCase("movie") ?externalJson.get("Website").asText() : "N/A";
		movieDto.response = externalJson.get("Response").asText();
		movieDto.isMovieSeen = false;

		return movieDto;
	}

	public MovieDto fromFalseResponseToDto(JsonNode externalJson) throws ParseException {
		MovieDto movieDto = new MovieDto();
		movieDto.response = externalJson.get("Response").asText();
		movieDto.error = externalJson.get("Error").asText();
		return movieDto;
	}

	public MovieDto fromMovieToDto(Movie movie) {
		MovieDto movieDto = new MovieDto();
		movieDto.title = movie.getTitle();
		movieDto.releaseDate = movie.getReleaseDate();
		movieDto.runtime = movie.getRuntime();
		movieDto.genre = movie.getGenre();
		movieDto.director = movie.getDirector();
		movieDto.writer = movie.getWriter();
		movieDto.actors = movie.getActors();
		movieDto.plot = movie.getPlot();
		movieDto.poster = movie.getPoster();
		movieDto.imdbRating = movie.getImdbRating();
		movieDto.imdbId = movie.getImdbId();
		movieDto.type = movie.getType();
		movieDto.boxOffice = movie.getBoxOffice();
		movieDto.production = movie.getProduction();
		movieDto.website = movie.getWebsite();
		movieDto.response = movie.getResponse();
		movieDto.isMovieSeen = movie.isMovieSeen();
		return movieDto;

	}

}
