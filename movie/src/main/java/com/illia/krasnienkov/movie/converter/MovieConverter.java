package com.illia.krasnienkov.movie.converter;

import com.illia.krasnienkov.movie.model.Movie;
import com.illia.krasnienkov.movie.dto.model_dtos.MovieDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MovieConverter implements Converter<Movie, MovieDto> {

    @Override
    public MovieDto convert(Movie movie) {
        MovieDto dto = new MovieDto();
            dto.setMovieId(UUID.fromString(movie.getId()));
            dto.setName(movie.getName());
            dto.setDescription(movie.getDescription());
            dto.setDuration(movie.getDuration());
            dto.setReleaseDate(movie.getReleaseDate());
            dto.setRating(movie.getRating());
        return dto;
    }
}
