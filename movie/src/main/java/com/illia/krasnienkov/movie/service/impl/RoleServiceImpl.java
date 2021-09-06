package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.model_dtos.RoleDto;
import com.illia.krasnienkov.movie.exceptions.ResourceNotFoundException;
import com.illia.krasnienkov.movie.model.Role;
import com.illia.krasnienkov.movie.repository.RoleRepository;
import com.illia.krasnienkov.movie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    private ConversionService service;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Cacheable(value = "role-cache")
    public Set<RoleDto> findByNameIn(Set<String> names) {
        Set<Role> roles = roleRepository.findByNameIn(names);
        if (roles.isEmpty()) {
            throw new ResourceNotFoundException("Roles with names + " + names.toString());
        }
        Set<RoleDto> roleDtoSet = roles.stream()
                .map(role -> service.convert(role, RoleDto.class))
                .collect(Collectors.toSet());
        return roleDtoSet;
    }

    public RoleDto create(Role role) {
        Role createdRole = roleRepository.save(role);
        return service.convert(createdRole, RoleDto.class);
    }

    public void deleteById(String id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isEmpty()) {
            throw new ResourceNotFoundException("Role with id " + id);
        }
        roleRepository.deleteById(id);
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> {
            throw new ResourceNotFoundException("Such role is");
        });
    }
}
