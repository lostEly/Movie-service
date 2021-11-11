package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.model_dtos.MovieListDto;
import com.illia.krasnienkov.movie.model.MovieList;
import com.illia.krasnienkov.movie.repository.MovieListRepository;
import com.illia.krasnienkov.movie.service.MovieListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieListServiceImpl extends ModelsServiceImpl<MovieListDto, MovieList> implements MovieListService {
    private final MovieListRepository movieListRepository = (MovieListRepository) this.repository;

    @Autowired
    protected MovieListServiceImpl(@Qualifier("movieListRepository") JpaRepository<MovieList, String> repository, ConversionService service) {
        super(repository, service, MovieListDto.class, MovieList.class);
    }
}
