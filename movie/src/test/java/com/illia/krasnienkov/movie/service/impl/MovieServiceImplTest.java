package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.TestDataFactory;
import com.illia.krasnienkov.movie.dto.model_dtos.MovieDto;
import com.illia.krasnienkov.movie.model.Movie;
import com.illia.krasnienkov.movie.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

class MovieServiceImplTest extends CommonServiceImplTest<MovieDto, Movie> {


    @Autowired
    public MovieServiceImplTest(MovieService movieService) {
        super(movieService);
    }

    @BeforeEach
    public void setUp() {
        setModel(TestDataFactory.createMovie());
        setDto(TestDataFactory.createMovieDto());
        setUpdatedModel(TestDataFactory.createUpdatedMovie());
        setPatchFields(createPatchFields());
    }

    private Map<String, Object> createPatchFields() {
        Map<String, Object> patchFields = new HashMap<>();
        patchFields.put("name", "patchedName");
        patchFields.put("description", "patchedDescription");
        return patchFields;
    }
}