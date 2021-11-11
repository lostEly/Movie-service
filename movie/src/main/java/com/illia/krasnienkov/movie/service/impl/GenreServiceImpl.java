package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.model_dtos.GenreDto;
import com.illia.krasnienkov.movie.model.Genre;
import com.illia.krasnienkov.movie.repository.GenreRepository;
import com.illia.krasnienkov.movie.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl extends ModelsServiceImpl<GenreDto, Genre> implements GenreService {
    private final GenreRepository genreRepository = (GenreRepository) this.repository;

    @Autowired
    protected GenreServiceImpl(@Qualifier("genreRepository") JpaRepository<Genre, String> repository, ConversionService service) {
        super(repository, service, GenreDto.class, Genre.class);
    }
}
