package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.model_dtos.ProfessionDto;
import com.illia.krasnienkov.movie.model.Profession;
import com.illia.krasnienkov.movie.repository.ProfessionRepository;
import com.illia.krasnienkov.movie.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessionServiceImpl extends ModelsServiceImpl<ProfessionDto, Profession> implements ProfessionService {
    private final ProfessionRepository professionRepository = (ProfessionRepository) this.repository;

    @Autowired
    protected ProfessionServiceImpl(@Qualifier("professionRepository") JpaRepository<Profession, String> repository, ConversionService service) {
        super(repository, service, ProfessionDto.class, Profession.class);
    }
}
