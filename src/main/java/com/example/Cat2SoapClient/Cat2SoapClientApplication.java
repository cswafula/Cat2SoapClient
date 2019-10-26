package com.example.Cat2SoapClient;

import localhost._8080.movies.GetMovieResponse;
import localhost._8080.movies.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Cat2SoapClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cat2SoapClientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(Client movieClient){

		return args -> {
			String moviename = "Spiderman: Far from home";
			if(args.length>0){
				moviename = args[0];
			}

			GetMovieResponse response = movieClient.getMovieResponse(moviename);
			Movie movie = response.getMovie();
			System.err.println(
					"Movie Name: "+movie.getName()+
							"\n Movie's Actor(s): "+movie.getActor()+
							"\n Movie's Capital: "+movie.getCapital()+
							"\n Movie's Category: "+movie.getCategory()+
							"\n Year Released: "+movie.getYearReleased()
			);
		};

	}

}
