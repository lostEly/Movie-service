package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.CountryDto;
import com.illia.krasnienkov.movie.exceptions.ResourceNotFoundException;
import com.illia.krasnienkov.movie.model.Country;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.repository.CountryRepository;
import com.illia.krasnienkov.movie.service.CountryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {
    private static final Logger LOGGER = LogManager.getLogger(CountryServiceImpl.class);
    private CountryRepository countryRepository;
    private ConversionService service;

    @Autowired
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Override
    public CountryDto create(Country country) {
        LOGGER.info("Started creating country");
        Country createdCountry = countryRepository.save(country);
        CountryDto newCountryDto = service.convert(createdCountry, CountryDto.class);
        LOGGER.info("Created country");
        return newCountryDto;
    }

    @Override
    public List<CountryDto> readAll() {
        LOGGER.info("Started reading all countrys");
        List<Country> countrys = countryRepository.findAll();
        LOGGER.info("Read all countrys");
        return countrys.stream()
                .map(country -> service.convert(country, CountryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CountryDto readById(String id) {
        LOGGER.info("Started reading country with id " + id);
        Country country = findCountryById(id);
        return service.convert(country, CountryDto.class);
    }

    @Override
    public CountryDto update(Country country) {
        LOGGER.warn("Started updating country with id + " + country.getId());
        if (country.getId() == null)
            throw new RuntimeException("UserId == null");
        Country updatedCountry = countryRepository.save(country);
        LOGGER.info("Country with id + " + updatedCountry.getId() + " is updated");
        return service.convert(updatedCountry, CountryDto.class);
    }

    @Override
    public CountryDto patch(Map<String, Object> fields, String id) {
        LOGGER.warn("Started patching country with id + " + id);
        Country country = findCountryById(id);
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(User.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, country, v);
        });
        Country patchedCountry = countryRepository.save(country);
        LOGGER.info("Country with id + " + country.getId() + " is patched");
        return service.convert(patchedCountry, CountryDto.class);
    }

    @Override
    public void deleteById(String id) {
        LOGGER.warn("Started deleting country with id " + id);
        Country country = findCountryById(id);
        countryRepository.delete(country);
        LOGGER.info("Finished deleting country with id " + id);
    }

    private Country findCountryById(String id) {
        LOGGER.info("Started reading country by id");
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if (optionalCountry.isEmpty()) {
            LOGGER.error("country with id + " + id + " not found");
            throw new ResourceNotFoundException("country with id " + id);
        }
        Country country = optionalCountry.get();
        LOGGER.info("Finished reading user by id");
        return country;
    }
}
