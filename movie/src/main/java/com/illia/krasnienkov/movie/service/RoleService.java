package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.model_dtos.RoleDto;
import com.illia.krasnienkov.movie.model.Role;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RoleService extends ModelsService<RoleDto, Role> {
    @Override
    RoleDto create(Role role);

    @Override
    List<RoleDto> readAll();

    @Override
    RoleDto readById(String id);

    @Override
    RoleDto update(Role role);

    @Override
    RoleDto patch(Map<String, Object> fields, String id);

    @Override
    void deleteById(String id);
}
