package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.model_dtos.ProfessionDto;
import com.illia.krasnienkov.movie.model.Profession;

import java.util.List;
import java.util.Map;

public interface ProfessionService extends ModelsService<ProfessionDto, Profession> {
    @Override
    ProfessionDto create(Profession profession);

    @Override
    List<ProfessionDto> readAll();

    @Override
    ProfessionDto readById(String id);

    @Override
    ProfessionDto update(Profession profession);

    @Override
    ProfessionDto patch(Map<String, Object> fields, String id);

    @Override
    void deleteById(String id);
}
