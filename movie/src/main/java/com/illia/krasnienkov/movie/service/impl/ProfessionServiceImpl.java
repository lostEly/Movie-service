package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.ProfessionDto;
import com.illia.krasnienkov.movie.exceptions.ResourceNotFoundException;
import com.illia.krasnienkov.movie.model.Profession;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.repository.ProfessionRepository;
import com.illia.krasnienkov.movie.service.ProfessionService;
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
public class ProfessionServiceImpl implements ProfessionService {
    private static final Logger LOGGER = LogManager.getLogger(ProfessionServiceImpl.class);
    private ProfessionRepository professionRepository;
    private ConversionService service;

    @Autowired
    public void setProfessionRepository(ProfessionRepository professionRepository) {
        this.professionRepository = professionRepository;
    }

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Override
    public ProfessionDto create(Profession profession) {
        LOGGER.info("Started creating profession");
        Profession createdProfession = professionRepository.save(profession);
        ProfessionDto newProfessionDto = service.convert(createdProfession, ProfessionDto.class);
        LOGGER.info("Created profession");
        return newProfessionDto;
    }

    @Override
    public List<ProfessionDto> readAll() {
        LOGGER.info("Started reading all professions");
        List<Profession> professions = professionRepository.findAll();
        LOGGER.info("Read all professions");
        return professions.stream()
                .map(profession -> service.convert(profession, ProfessionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProfessionDto readById(String id) {
        LOGGER.info("Started reading profession with id " + id);
        Profession profession = findProfessionById(id);
        return service.convert(profession, ProfessionDto.class);
    }

    @Override
    public ProfessionDto update(Profession profession) {
        LOGGER.warn("Started updating profession with id + " + profession.getId());
        if (profession.getId() == null)
            throw new RuntimeException("UserId == null");
        Profession updatedProfession = professionRepository.save(profession);
        LOGGER.info("Profession with id + " + updatedProfession.getId() + " is updated");
        return service.convert(updatedProfession, ProfessionDto.class);
    }

    @Override
    public ProfessionDto patch(Map<String, Object> fields, String id) {
        LOGGER.warn("Started patching profession with id + " + id);
        Profession profession = findProfessionById(id);
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(User.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, profession, v);
        });
        Profession patchedProfession = professionRepository.save(profession);
        LOGGER.info("Profession with id + " + profession.getId() + " is patched");
        return service.convert(patchedProfession, ProfessionDto.class);
    }

    @Override
    public void deleteById(String id) {
        LOGGER.warn("Started deleting profession with id " + id);
        Profession profession = findProfessionById(id);
        professionRepository.delete(profession);
        LOGGER.info("Finished deleting profession with id " + id);
    }

    private Profession findProfessionById(String id) {
        LOGGER.info("Started reading profession by id");
        Optional<Profession> optionalProfession = professionRepository.findById(id);
        if (optionalProfession.isEmpty()) {
            LOGGER.error("profession with id + " + id + " not found");
            throw new ResourceNotFoundException("profession with id " + id);
        }
        Profession profession = optionalProfession.get();
        LOGGER.info("Finished reading user by id");
        return profession;
    }
}
