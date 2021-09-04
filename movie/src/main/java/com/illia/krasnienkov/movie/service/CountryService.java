package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.CountryDto;
import com.illia.krasnienkov.movie.model.Country;

import java.util.List;
import java.util.Map;

public interface CountryService {
    CountryDto create(Country country);

    List<CountryDto> readAll();

    CountryDto readById(String id);

    CountryDto update(Country country);

    CountryDto patch(Map<String, Object> fields, String id);

    void deleteById(String id);
}
