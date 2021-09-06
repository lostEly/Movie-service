package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.model_dtos.GenreDto;
import com.illia.krasnienkov.movie.model.Genre;

import java.util.List;
import java.util.Map;

public interface GenreService {
    GenreDto create(Genre genre);

    List<GenreDto> readAll();

    GenreDto readById(String id);

    GenreDto update(Genre genre);

    GenreDto patch(Map<String, Object> fields, String id);

    void deleteById(String id);
}
