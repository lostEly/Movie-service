package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.model.Role;
import com.illia.krasnienkov.movie.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Set<Role> findByNameIn(Set<String> names) {
        Set<Role> roles = roleRepository.findByNameIn(names);
        if (roles.isEmpty()) throw new RuntimeException("No roles found");
        return roles;
    }

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> {
            throw new RuntimeException("No such role found");
        });
    }
}
