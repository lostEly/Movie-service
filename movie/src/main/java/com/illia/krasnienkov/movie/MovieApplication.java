package com.illia.krasnienkov.movie;

import com.illia.krasnienkov.movie.model.Movie;
import com.illia.krasnienkov.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@SpringBootApplication
public class MovieApplication {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void test(){
        Movie movie = new Movie();
        movie.setId(UUID.randomUUID());
        movie.setName("Leon");
        movie.setDescription("killer");
        movie.setDuration(LocalTime.now());
        movie.setReleaseDate(LocalDate.now().minusYears(10));
        movie.setRating(7.8);
        movieService.test(movie);
    }

}
