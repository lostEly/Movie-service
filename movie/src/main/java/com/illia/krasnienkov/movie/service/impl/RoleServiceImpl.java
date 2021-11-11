package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.model_dtos.RoleDto;
import com.illia.krasnienkov.movie.exceptions.ResourceNotFoundException;
import com.illia.krasnienkov.movie.model.Role;
import com.illia.krasnienkov.movie.repository.RoleRepository;
import com.illia.krasnienkov.movie.service.RoleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends ModelsServiceImpl<RoleDto, Role> implements RoleService {

    private final RoleRepository roleRepository = (RoleRepository) this.repository;

    protected RoleServiceImpl(@Qualifier("roleRepository") JpaRepository<Role, String> repository, ConversionService service) {
        super(repository, service, RoleDto.class, Role.class);
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

    public Role findByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> {
            throw new ResourceNotFoundException("Such role is");
        });
    }

}
