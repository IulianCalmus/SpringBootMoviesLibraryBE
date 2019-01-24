package com.movies.library.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${omdb.service.api.key}")
	String serviceApiKey;

	private static final String URL_TEMPLATE_TITLE_YEAR = "http://www.omdbapi.com/?t=%s&y=%s&apikey=%s";
	private static final String URL_TEMPLATE_TITLE = "http://www.omdbapi.com/?t=%s&apikey=%s";

	public MovieService() {

	}

	public ResponseEntity<String> serveMovie(String movieTitle, String year) throws IOException {

		String resourceUrlTemplate = null;
		if (!year.isEmpty()) {
			resourceUrlTemplate = String.format(URL_TEMPLATE_TITLE_YEAR, movieTitle, year, serviceApiKey);
		} else {
			resourceUrlTemplate = String.format(URL_TEMPLATE_TITLE, movieTitle, serviceApiKey);
		}
		ResponseEntity<String> response = restTemplate.getForEntity(resourceUrlTemplate, String.class);
		System.out.println("NA response " + response);
		
//		cand se va implementa global exception handler
//		if (serviceResponse.getStatusCode().equals(HttpStatus.OK)) {
//			return root;
//		} else {
//			throw service unavailable exception;
//		}
		
		return response;
	}

}
