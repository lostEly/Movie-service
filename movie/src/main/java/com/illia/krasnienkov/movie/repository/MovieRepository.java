package com.illia.krasnienkov.movie.repository;

import com.illia.krasnienkov.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface MovieRepository extends JpaRepository<Movie, String> {
}
