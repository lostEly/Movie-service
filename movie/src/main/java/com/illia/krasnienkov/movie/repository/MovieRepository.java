package com.illia.krasnienkov.movie.repository;

import com.illia.krasnienkov.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;


public interface MovieRepository extends JpaRepository<Movie, String> {
    @Query(nativeQuery = true)
    Movie namedGetRandomMovie();

    @Query(nativeQuery = true)
    Movie namedSortMoviesByRating();
}
