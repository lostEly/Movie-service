package com.softserveinc.illia.krasnienkov.movie.repository;

import com.softserveinc.illia.krasnienkov.movie.model.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieListToMovieRepository extends JpaRepository<MovieList, Long> {
}
