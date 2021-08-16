package com.illia.krasnienkov.movie.controller;

import com.illia.krasnienkov.movie.model.Role;
import com.illia.krasnienkov.movie.service.RoleService;
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
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/test")
    public ResponseEntity<Set<Role>> readByNameIn(@RequestBody Set<String> names) {
        Set<Role> roles = roleService.findByNameIn(names);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role role) {
        Role newRole = roleService.create(role);
        return new ResponseEntity<>(newRole, HttpStatus.OK);
    }
}
