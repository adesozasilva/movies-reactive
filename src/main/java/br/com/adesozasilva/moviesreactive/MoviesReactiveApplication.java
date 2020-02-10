package br.com.adesozasilva.moviesreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class MoviesReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesReactiveApplication.class, args);
	}

}
