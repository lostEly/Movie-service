package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.model.Role;

import java.util.Set;
import java.util.UUID;

public interface RoleService {
    Set<Role> findByNameIn(Set<String> names);
    Role create(Role role);
    void delete(UUID id);
    Role findByName(String name);
}
