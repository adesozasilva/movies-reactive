package br.com.adesozasilva.moviesreactive;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class MovieWebClient {

    private WebClient webClient = WebClient.create("http://localhost:8080");

    public Mono<Movie> findMovieById(Long id) {
        return webClient.get().uri("/movies/{id}", String.valueOf(id))
                .retrieve()
                .bodyToMono(Movie.class);
    }
}
