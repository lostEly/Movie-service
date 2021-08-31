package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.MovieListToMovieDto;
import com.illia.krasnienkov.movie.exceptions.ResourceNotFoundException;
import com.illia.krasnienkov.movie.model.MovieListToMovie;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.repository.MovieListToMovieRepository;
import com.illia.krasnienkov.movie.service.MovieListToMovieService;
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
public class MovieListToMovieServiceImpl implements MovieListToMovieService {
    private static final Logger LOGGER = LogManager.getLogger(MovieListToMovieServiceImpl.class);
    private MovieListToMovieRepository movieListToMovieRepository;
    private ConversionService service;

    @Autowired
    public void setMovieListToMovieRepository(MovieListToMovieRepository movieListToMovieRepository) {
        this.movieListToMovieRepository = movieListToMovieRepository;
    }

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Override
    public MovieListToMovieDto create(MovieListToMovie movieListToMovie) {
        LOGGER.info("Started creating movieListToMovie");
        MovieListToMovie createdMovieListToMovie = movieListToMovieRepository.save(movieListToMovie);
        MovieListToMovieDto newMovieListToMovieDto = service.convert(createdMovieListToMovie, MovieListToMovieDto.class);
        LOGGER.info("Created movieListToMovie");
        return newMovieListToMovieDto;
    }

    @Override
    public List<MovieListToMovieDto> readAll() {
        LOGGER.info("Started reading all movieListToMovies");
        List<MovieListToMovie> movieListToMovies = movieListToMovieRepository.findAll();
        LOGGER.info("Read all movieListToMovies");
        return movieListToMovies.stream()
                .map(movieListToMovie -> service.convert(movieListToMovie, MovieListToMovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovieListToMovieDto readById(String id) {
        LOGGER.info("Started reading movieListToMovie with id " + id);
        MovieListToMovie movieListToMovie = findMovieListToMovieById(id);
        return service.convert(movieListToMovie, MovieListToMovieDto.class);
    }

    @Override
    public MovieListToMovieDto update(MovieListToMovie movieListToMovie) {
        LOGGER.warn("Started updating movieListToMovie with id + " + movieListToMovie.getId());
        if (movieListToMovie.getId() == null)
            throw new RuntimeException("UserId == null");
        MovieListToMovie updatedMovieListToMovie = movieListToMovieRepository.save(movieListToMovie);
        LOGGER.info("MovieListToMovie with id + " + updatedMovieListToMovie.getId() + " is updated");
        return service.convert(updatedMovieListToMovie, MovieListToMovieDto.class);
    }

    @Override
    public MovieListToMovieDto patch(Map<String, Object> fields, String id) {
        LOGGER.warn("Started patching movieListToMovie with id + " + id);
        MovieListToMovie movieListToMovie = findMovieListToMovieById(id);
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(User.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, movieListToMovie, v);
        });
        MovieListToMovie patchedMovieListToMovie = movieListToMovieRepository.save(movieListToMovie);
        LOGGER.info("MovieListToMovie with id + " + movieListToMovie.getId() + " is patched");
        return service.convert(patchedMovieListToMovie, MovieListToMovieDto.class);
    }

    @Override
    public void deleteById(String id) {
        LOGGER.warn("Started deleting movieListToMovie with id " + id);
        MovieListToMovie movieListToMovie = findMovieListToMovieById(id);
        movieListToMovieRepository.delete(movieListToMovie);
        LOGGER.info("Finished deleting movieListToMovie with id " + id);
    }

    private MovieListToMovie findMovieListToMovieById(String id) {
        LOGGER.info("Started reading movieListToMovie by id");
        Optional<MovieListToMovie> optionalMovieListToMovie = movieListToMovieRepository.findById(id);
        if (optionalMovieListToMovie.isEmpty()) {
            LOGGER.error("movieListToMovie with id + " + id + " not found");
            throw new ResourceNotFoundException("movieListToMovie with id " + id);
        }
        MovieListToMovie movieListToMovie = optionalMovieListToMovie.get();
        LOGGER.info("Finished reading user by id");
        return movieListToMovie;
    }
}
