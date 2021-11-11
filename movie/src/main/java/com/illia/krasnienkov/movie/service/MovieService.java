package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.model_dtos.MovieDto;
import com.illia.krasnienkov.movie.dto.movie_info.MovieInformationDto;
import com.illia.krasnienkov.movie.model.Movie;

public interface MovieService extends ModelsService<MovieDto, Movie> {

    public MovieInformationDto getMovieInformation(String id);

    public MovieDto getRandomMovie();
}
