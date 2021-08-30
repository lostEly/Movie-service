package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.MovieListDto;
import com.illia.krasnienkov.movie.model.MovieList;

import java.util.List;
import java.util.Map;

public interface MovieListService {
    MovieListDto create(MovieList movieList);

    List<MovieListDto> readAll();

    MovieListDto readById(String id);

    MovieListDto update(MovieList movieList);

    MovieListDto patch(Map<String, Object> fields, String id);

    void deleteById(String id);
}
