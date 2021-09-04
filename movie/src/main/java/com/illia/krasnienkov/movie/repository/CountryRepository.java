package com.illia.krasnienkov.movie.repository;

import com.illia.krasnienkov.movie.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
