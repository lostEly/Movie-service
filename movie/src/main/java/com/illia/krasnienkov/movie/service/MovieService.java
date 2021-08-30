package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.MovieDto;
import com.illia.krasnienkov.movie.model.Movie;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface MovieService {
    MovieDto create(Movie movie);

    List<MovieDto> readAll();

    MovieDto readById(String id);

    MovieDto update(Movie movie);

    MovieDto patch(Map<String, Object> fields, String id);

    void deleteById(String id);
}
