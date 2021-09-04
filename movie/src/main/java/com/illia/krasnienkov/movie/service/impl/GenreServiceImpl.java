package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.GenreDto;
import com.illia.krasnienkov.movie.exceptions.ResourceNotFoundException;
import com.illia.krasnienkov.movie.model.Genre;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.repository.GenreRepository;
import com.illia.krasnienkov.movie.service.GenreService;
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
public class GenreServiceImpl implements GenreService {
    private static final Logger LOGGER = LogManager.getLogger(GenreServiceImpl.class);
    private GenreRepository genreRepository;
    private ConversionService service;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Override
    public GenreDto create(Genre genre) {
        LOGGER.info("Started creating genre");
        Genre createdGenre = genreRepository.save(genre);
        GenreDto newGenreDto = service.convert(createdGenre, GenreDto.class);
        LOGGER.info("Created genre");
        return newGenreDto;
    }

    @Override
    public List<GenreDto> readAll() {
        LOGGER.info("Started reading all genres");
        List<Genre> genres = genreRepository.findAll();
        LOGGER.info("Read all genres");
        return genres.stream()
                .map(genre -> service.convert(genre, GenreDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GenreDto readById(String id) {
        LOGGER.info("Started reading genre with id " + id);
        Genre genre = findGenreById(id);
        return service.convert(genre, GenreDto.class);
    }

    @Override
    public GenreDto update(Genre genre) {
        LOGGER.warn("Started updating genre with id + " + genre.getId());
        if (genre.getId() == null)
            throw new RuntimeException("UserId == null");
        Genre updatedGenre = genreRepository.save(genre);
        LOGGER.info("Genre with id + " + updatedGenre.getId() + " is updated");
        return service.convert(updatedGenre, GenreDto.class);
    }

    @Override
    public GenreDto patch(Map<String, Object> fields, String id) {
        LOGGER.warn("Started patching genre with id + " + id);
        Genre genre = findGenreById(id);
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(User.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, genre, v);
        });
        Genre patchedGenre = genreRepository.save(genre);
        LOGGER.info("Genre with id + " + genre.getId() + " is patched");
        return service.convert(patchedGenre, GenreDto.class);
    }

    @Override
    public void deleteById(String id) {
        LOGGER.warn("Started deleting genre with id " + id);
        Genre genre = findGenreById(id);
        genreRepository.delete(genre);
        LOGGER.info("Finished deleting genre with id " + id);
    }

    private Genre findGenreById(String id) {
        LOGGER.info("Started reading genre by id");
        Optional<Genre> optionalGenre = genreRepository.findById(id);
        if (optionalGenre.isEmpty()) {
            LOGGER.error("genre with id + " + id + " not found");
            throw new ResourceNotFoundException("genre with id " + id);
        }
        Genre genre = optionalGenre.get();
        LOGGER.info("Finished reading user by id");
        return genre;
    }
}
