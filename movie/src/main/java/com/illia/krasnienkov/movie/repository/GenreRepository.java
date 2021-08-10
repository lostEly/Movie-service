package com.illia.krasnienkov.movie.repository;

import com.illia.krasnienkov.movie.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {
}
