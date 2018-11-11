package com.movies.library;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) // Disables security
// @ComponentScan(basePackages = {"com.movies.library.service",
// "com.movies.library.repository", "com.movies.library.rest.controller"})
// @EntityScan(basePackages = {"com.movies.library.entity", })
public class MoviesLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesLibraryApplication.class, args);
		// ApplicationCOntext = new ClassPath
	}

	// @Bean
	// public RestTemplate restTemplate(RestTemplateBuilder templateBuilder) {
	// return templateBuilder.build();
	// }

	 @Bean
	 public RestTemplate restTemplate(RestTemplateBuilder builder) {
	 return builder.build();
	 }

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			// for (String beanName : beanNames) {
//			// System.out.println(beanNames);
//			// }
//			Arrays.asList(beanNames).stream().forEach(System.out::println);
//			System.out.println("REST TEMPLATE" + ctx.getBean(RestTemplate.class));
//			System.out.println("ASTEA SUNT TOATE : " + ctx.getBeanDefinitionCount());
//		};
//	}
}
