package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.model_dtos.GenreDto;
import com.illia.krasnienkov.movie.model.Genre;

import java.util.List;
import java.util.Map;

public interface GenreService extends ModelsService<GenreDto, Genre> {

    @Override
    GenreDto create(Genre genre);

    @Override
    List<GenreDto> readAll();

    @Override
    GenreDto readById(String id);

    @Override
    GenreDto update(Genre genre);

    @Override
    GenreDto patch(Map<String, Object> fields, String id);

    @Override
    void deleteById(String id);
}
