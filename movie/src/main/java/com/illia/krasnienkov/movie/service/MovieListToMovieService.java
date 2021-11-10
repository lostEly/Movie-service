package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.model_dtos.MovieListToMovieDto;
import com.illia.krasnienkov.movie.model.MovieListToMovie;

import java.util.List;
import java.util.Map;

public interface MovieListToMovieService extends ModelsService<MovieListToMovieDto, MovieListToMovie> {
    @Override
    MovieListToMovieDto create(MovieListToMovie movieListToMovie);

    @Override
    List<MovieListToMovieDto> readAll();

    @Override
    MovieListToMovieDto readById(String id);

    @Override
    MovieListToMovieDto update(MovieListToMovie movieListToMovie);

    @Override
    MovieListToMovieDto patch(Map<String, Object> fields, String id);

    @Override
    void deleteById(String id);
}
