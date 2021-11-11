package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.model_dtos.MovieListToMovieDto;
import com.illia.krasnienkov.movie.model.MovieListToMovie;
import com.illia.krasnienkov.movie.repository.MovieListToMovieRepository;
import com.illia.krasnienkov.movie.service.MovieListToMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieListToMovieServiceImpl extends ModelsServiceImpl<MovieListToMovieDto, MovieListToMovie> implements MovieListToMovieService {
    private final MovieListToMovieRepository movieListToMovieRepository = (MovieListToMovieRepository) this.repository;

    @Autowired
    protected MovieListToMovieServiceImpl(@Qualifier("movieListToMovieRepository") JpaRepository<MovieListToMovie, String> repository, ConversionService service) {
        super(repository, service, MovieListToMovieDto.class, MovieListToMovie.class);
    }
}
