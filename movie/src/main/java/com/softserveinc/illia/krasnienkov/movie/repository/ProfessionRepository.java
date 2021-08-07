package com.softserveinc.illia.krasnienkov.movie.repository;

import com.softserveinc.illia.krasnienkov.movie.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}
