package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.model_dtos.MovieListToMovieDto;
import com.illia.krasnienkov.movie.model.MovieListToMovie;

import java.util.List;
import java.util.Map;

public interface MovieListToMovieService {
    MovieListToMovieDto create(MovieListToMovie movieListToMovie);

    List<MovieListToMovieDto> readAll();

    MovieListToMovieDto readById(String id);

    MovieListToMovieDto update(MovieListToMovie movieListToMovie);

    MovieListToMovieDto patch(Map<String, Object> fields, String id);

    void deleteById(String id);
}
