package com.illia.krasnienkov.movie;

import com.illia.krasnienkov.movie.model.Movie;
import com.illia.krasnienkov.movie.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.convert.ConversionService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@SpringBootApplication
public class MovieApplication {

    private MovieServiceImpl movieServiceImpl;
    private ConversionService conversionService;

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }

    @Autowired
    public void setMovieService(MovieServiceImpl movieServiceImpl) {
        this.movieServiceImpl = movieServiceImpl;
    }

    @Autowired
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        Movie movie = new Movie();
        movie.setId(UUID.randomUUID());
        movie.setName("Leon");
        movie.setDescription("killer");
        movie.setDuration(LocalTime.now());
        movie.setReleaseDate(LocalDate.now().minusYears(10));
        movie.setRating(7.8);
        movieServiceImpl.test(movie);
    }
}
