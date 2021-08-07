package com.softserveinc.illia.krasnienkov.movie.repository;

import com.softserveinc.illia.krasnienkov.movie.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
