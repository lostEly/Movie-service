package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.ProfessionDto;
import com.illia.krasnienkov.movie.model.Profession;

import java.util.List;
import java.util.Map;

public interface ProfessionService {
    ProfessionDto create(Profession profession);

    List<ProfessionDto> readAll();

    ProfessionDto readById(String id);

    ProfessionDto update(Profession profession);

    ProfessionDto patch(Map<String, Object> fields, String id);

    void deleteById(String id);
}
