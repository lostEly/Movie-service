package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.MovieDto;
import com.illia.krasnienkov.movie.dto.UserDto;
import com.illia.krasnienkov.movie.model.Movie;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService {

    private ConversionService service;

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Override
    public MovieDto create(Movie movie) {
        return null;
    }

    @Override
    public List<MovieDto> readAll() {
        return null;
    }

    @Override
    public MovieDto readById(UUID id) {
        return null;
    }

    @Override
    public MovieDto update(Movie movie) {
        return null;
    }

    @Override
    public MovieDto patch(Map<String, Object> fields, UUID id) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
