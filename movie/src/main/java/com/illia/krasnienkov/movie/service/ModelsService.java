package com.illia.krasnienkov.movie.service;

import java.util.List;
import java.util.Map;

public interface ModelsService<D, M> {
    D create(M m);

    List<D> readAll();

    D readById(String id);

    D update(M m);

    D patch(Map<String, Object> fields, String id);

    void deleteById(String id);

    M findById(String id);
}
