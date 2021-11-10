package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.model_dtos.CountryDto;
import com.illia.krasnienkov.movie.model.Country;

import java.util.List;
import java.util.Map;

public interface CountryService extends ModelsService<CountryDto, Country> {

    @Override
    CountryDto create(Country country);

    @Override
    List<CountryDto> readAll();

    @Override
    CountryDto readById(String id);

    @Override
    CountryDto update(Country country);

    @Override
    CountryDto patch(Map<String, Object> fields, String id);

    @Override
    void deleteById(String id);
}
