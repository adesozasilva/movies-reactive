package br.com.adesozasilva.moviesreactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("movies-reactive")
public class MoviesReactiveController {

    @Autowired
    private MovieWebClient movieWebClient;

    @GetMapping("{id}")
    public Mono<ResponseEntity<Movie>> findMovieById(@PathVariable Long id) {
       return movieWebClient.findMovieById(id)
               .log()
               .map(movie ->  new ResponseEntity<Movie>(movie, HttpStatus.OK))
               .log()
               .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
