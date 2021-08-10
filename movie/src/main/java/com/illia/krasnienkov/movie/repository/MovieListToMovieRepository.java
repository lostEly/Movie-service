package com.illia.krasnienkov.movie.repository;

import com.illia.krasnienkov.movie.model.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieListToMovieRepository extends JpaRepository<MovieList, UUID> {
}
