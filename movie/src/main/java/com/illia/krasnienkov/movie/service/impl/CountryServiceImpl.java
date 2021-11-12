package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.model_dtos.CountryDto;
import com.illia.krasnienkov.movie.model.Country;
import com.illia.krasnienkov.movie.repository.CountryRepository;
import com.illia.krasnienkov.movie.service.CountryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends ModelsServiceImpl<CountryDto, Country> implements CountryService {
    private final CountryRepository countryRepository = (CountryRepository) this.repository;

    protected CountryServiceImpl(@Qualifier("countryRepository") JpaRepository<Country, String> repository, ConversionService service) {
        super(repository, service, CountryDto.class, Country.class);
    }
}
