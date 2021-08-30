package com.illia.krasnienkov.movie.repository;

import com.illia.krasnienkov.movie.model.MovieList;
import com.illia.krasnienkov.movie.model.MovieListToMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieListToMovieRepository extends JpaRepository<MovieListToMovie, String> {
}
