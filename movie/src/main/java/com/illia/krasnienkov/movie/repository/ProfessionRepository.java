package com.illia.krasnienkov.movie.repository;

import com.illia.krasnienkov.movie.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessionRepository extends JpaRepository<Profession, UUID> {
}
