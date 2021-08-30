package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.MovieListDto;
import com.illia.krasnienkov.movie.dto.UserDto;
import com.illia.krasnienkov.movie.exceptions.ResourceNotFoundException;
import com.illia.krasnienkov.movie.model.MovieList;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.repository.MovieListRepository;
import com.illia.krasnienkov.movie.service.MovieListService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieListServiceImpl implements MovieListService {
    private static final Logger LOGGER = LogManager.getLogger(MovieListServiceImpl.class);
    private MovieListRepository movieListRepository;
    private ConversionService service;

    @Autowired
    public void setMovieListRepository(MovieListRepository movieListRepository) {
        this.movieListRepository = movieListRepository;
    }

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Override
    public MovieListDto create(MovieList movieList) {
        LOGGER.info("Started creating movieList");
        MovieList createdMovieList = movieListRepository.save(movieList);
        MovieListDto newMovieListDto = service.convert(createdMovieList, MovieListDto.class);
        LOGGER.info("Created movieList");
        return newMovieListDto;
    }

    @Override
    public List<MovieListDto> readAll() {
        LOGGER.info("Started reading all movieLists");
        List<MovieList> movieLists = movieListRepository.findAll();
        LOGGER.info("Read all movieLists");
        return movieLists.stream()
                .map(movieList -> service.convert(movieList, MovieListDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovieListDto readById(String id) {
        LOGGER.info("Started reading movieList with id " + id);
        MovieList movieList = findMovieListById(id);
        return service.convert(movieList, MovieListDto.class);
    }

    @Override
    public MovieListDto update(MovieList movieList) {
        LOGGER.warn("Started updating movieList with id + " + movieList.getId());
        if (movieList.getId() == null)
            throw new RuntimeException("UserId == null");
        MovieList updatedMovieList = movieListRepository.save(movieList);
        LOGGER.info("MovieList with id + " + updatedMovieList.getId() + " is updated");
        return service.convert(updatedMovieList, MovieListDto.class);
    }

    @Override
    public MovieListDto patch(Map<String, Object> fields, String id) {
        LOGGER.warn("Started patching movieList with id + " + id);
        MovieList movieList = findMovieListById(id);
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(User.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, movieList, v);
        });
        MovieList patchedMovieList = movieListRepository.save(movieList);
        LOGGER.info("MovieList with id + " + movieList.getId() + " is patched");
        return service.convert(patchedMovieList, MovieListDto.class);
    }

    @Override
    public void deleteById(String id) {
        LOGGER.warn("Started deleting movieList with id " + id);
        MovieList movieList = findMovieListById(id);
        movieListRepository.delete(movieList);
        LOGGER.info("Finished deleting movieList with id " + id);
    }

    private MovieList findMovieListById(String id) {
        LOGGER.info("Started reading movieList by id");
        Optional<MovieList> optionalMovieList = movieListRepository.findById(id);
        if (optionalMovieList.isEmpty()) {
            LOGGER.error("movieList with id + " + id + " not found");
            throw new ResourceNotFoundException("movieList with id " + id);
        }
        MovieList movieList = optionalMovieList.get();
        LOGGER.info("Finished reading user by id");
        return movieList;
    }
}
