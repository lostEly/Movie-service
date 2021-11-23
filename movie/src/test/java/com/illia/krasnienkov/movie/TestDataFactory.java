package com.illia.krasnienkov.movie;

import com.illia.krasnienkov.movie.dto.model_dtos.MovieDto;
import com.illia.krasnienkov.movie.model.Movie;
import com.illia.krasnienkov.movie.test_data.MovieTestData;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestDataFactory {
    static Movie movie;
    static MovieDto movieDto;
    static Movie updatedMovie;

    public static Movie createMovie() {
        if (movie != null)
            return movie;
        movie = new Movie();
        movie.setId(MovieTestData.ID);
        movie.setName(MovieTestData.NAME);
        movie.setDescription(MovieTestData.DESCRIPTION);
        movie.setRating(MovieTestData.RATING);
        movie.setReleaseDate(MovieTestData.RELEASE_DATE);
        movie.setDuration(MovieTestData.DURATION);
        return movie;
    }

    public static Movie createUpdatedMovie() {
        if (updatedMovie != null)
            return updatedMovie;
        updatedMovie = new Movie();
        updatedMovie.setId(MovieTestData.ID);
        updatedMovie.setName("updated " + MovieTestData.NAME);
        updatedMovie.setDescription("updated " + MovieTestData.DESCRIPTION);
        updatedMovie.setRating(MovieTestData.RATING - 5d);
        updatedMovie.setReleaseDate(MovieTestData.RELEASE_DATE);
        updatedMovie.setDuration(MovieTestData.DURATION);
        updatedMovie.setDateUpdated(LocalDateTime.now());
        return updatedMovie;
    }

    public static MovieDto createMovieDto() {
        if (movieDto != null)
            return movieDto;
        movieDto = new MovieDto();
        movieDto.setId(UUID.fromString(MovieTestData.ID));
        movieDto.setName(MovieTestData.NAME);
        movieDto.setDescription(MovieTestData.DESCRIPTION);
        movieDto.setRating(MovieTestData.RATING);
        movieDto.setReleaseDate(MovieTestData.RELEASE_DATE);
        movieDto.setDuration(MovieTestData.DURATION);
        return movieDto;
    }

    public static Map<String, Object> createMoviePatchFields() {
        Map<String, Object> patchFields = new HashMap<>();
        patchFields.put("name", "patchedName");
        patchFields.put("description", "patchedDescription");
        return patchFields;
    }
}
