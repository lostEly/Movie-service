package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.model_dtos.MovieDto;
import com.illia.krasnienkov.movie.dto.movie_info.MovieInformationDto;
import com.illia.krasnienkov.movie.model.Movie;

import java.util.List;
import java.util.Map;

public interface MovieService extends ModelsService<MovieDto, Movie> {
    @Override
    MovieDto create(Movie movie);

    @Override
    List<MovieDto> readAll();

    @Override
    MovieDto readById(String id);

    @Override
    MovieDto update(Movie movie);

    @Override
    MovieDto patch(Map<String, Object> fields, String id);

    @Override
    void deleteById(String id);
}
