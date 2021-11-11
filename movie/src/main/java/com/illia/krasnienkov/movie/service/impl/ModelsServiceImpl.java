package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.exceptions.ResourceNotFoundException;
import com.illia.krasnienkov.movie.service.ModelsService;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class ModelsServiceImpl<D, M> implements ModelsService<D, M> {
    protected JpaRepository<M, String> repository;
    protected ConversionService service;
    protected Class<D> dtoType;
    protected Class<M> modelType;

    protected ModelsServiceImpl(JpaRepository<M, String> repository, ConversionService service, Class<D> dtoType, Class<M> modelType) {
        this.repository = repository;
        this.service = service;
        this.dtoType = dtoType;
        this.modelType = modelType;
    }

    @Override
    public D create(M m) {
        M model = repository.save(m);
        return service.convert(model, dtoType);
    }

    @Override
    public List<D> readAll() {
        List<M> models = repository.findAll();
        return models.stream()
                .map(element -> service.convert(element, dtoType))
                .collect(Collectors.toList());
    }

    @Override
    public D readById(String id) {
        M model = repository.findById(id)
                .orElseThrow(() -> {
                    throw new ResourceNotFoundException(dtoType, id);
                });
        return service.convert(model, dtoType);
    }

    @Override
    public D update(M m) {
        M model = repository.save(m);
        return service.convert(model, dtoType);
    }

    @Override
    public D patch(Map<String, Object> fields, String id) {
        M model = findById(id);
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(modelType, k);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, model, v);
            }
        });
        M patchedModel = repository.save(model);
        return service.convert(patchedModel, dtoType);

    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public M findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(modelType, id));

    }
}
