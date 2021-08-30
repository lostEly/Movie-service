package com.illia.krasnienkov.movie.controller;

import com.illia.krasnienkov.movie.dto.RoleDto;
import com.illia.krasnienkov.movie.model.Role;
import com.illia.krasnienkov.movie.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private RoleServiceImpl roleService;

    @Autowired
    public void setRoleService(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/test")
    public ResponseEntity<Set<RoleDto>> readByNameIn(@RequestBody Set<String> names) {
        Set<RoleDto> roleDtoSet = roleService.findByNameIn(names);
        return new ResponseEntity<>(roleDtoSet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleDto> create(@RequestBody Role role) {
        RoleDto newRole = roleService.create(role);
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }
}
