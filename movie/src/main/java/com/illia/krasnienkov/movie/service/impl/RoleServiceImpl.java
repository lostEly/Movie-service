package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.model.Role;
import com.illia.krasnienkov.movie.repository.RoleRepository;
import com.illia.krasnienkov.movie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    //@TODO
    // create logic of exception handling of not found roles
    public Set<Role> findByNameIn(Set<String> names) {
        Set<Role> roles = roleRepository.findByNameIn(names);
        return roles;
    }

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public void delete(UUID id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isEmpty()) {
            throw new RuntimeException("Role with id " + id + " not found");
        }
        roleRepository.deleteById(id);
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> {
            throw new RuntimeException("No such role found");
        });
    }
}
