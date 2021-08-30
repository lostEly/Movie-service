package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.RoleDto;
import com.illia.krasnienkov.movie.model.Role;

import java.util.Set;

public interface RoleService {
    Set<RoleDto> findByNameIn(Set<String> names);

    RoleDto create(Role role);

    void deleteById(String id);

    Role findByName(String name);
}
