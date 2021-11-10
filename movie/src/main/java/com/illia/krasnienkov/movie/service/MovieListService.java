package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.model_dtos.MovieListDto;
import com.illia.krasnienkov.movie.model.MovieList;

import java.util.List;
import java.util.Map;

public interface MovieListService extends ModelsService<MovieListDto, MovieList> {
    @Override
    MovieListDto create(MovieList movieList);

    @Override
    List<MovieListDto> readAll();

    @Override
    MovieListDto readById(String id);

    @Override
    MovieListDto update(MovieList movieList);

    @Override
    MovieListDto patch(Map<String, Object> fields, String id);

    @Override
    void deleteById(String id);
}
