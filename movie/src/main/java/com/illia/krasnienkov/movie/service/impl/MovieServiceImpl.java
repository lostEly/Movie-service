package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.model_dtos.MovieDto;
import com.illia.krasnienkov.movie.dto.movie_info.MovieInformationDto;
import com.illia.krasnienkov.movie.model.Movie;
import com.illia.krasnienkov.movie.repository.MovieRepository;
import com.illia.krasnienkov.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MovieServiceImpl implements MovieService {

    private ConversionService service;
    private MovieRepository movieRepository;

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
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
    public MovieDto readById(String id) {
        return null;
    }

    @Override
    public MovieDto update(Movie movie) {
        return null;
    }

    @Override
    public MovieDto patch(Map<String, Object> fields, String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public MovieDto getRandomMovie() {
        Movie randomMovie = movieRepository.namedGetRandomMovie();
        return service.convert(randomMovie, MovieDto.class);
    }

    public List<Object[]> getMovieInformation(String id) {
        return movieRepository.namedGetAllMovieInfo(id);
    }


}
