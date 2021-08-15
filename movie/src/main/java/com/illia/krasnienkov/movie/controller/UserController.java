package com.illia.krasnienkov.movie.controller;

import com.illia.krasnienkov.movie.dto.UserDto;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> readById(@PathVariable String id) {
        UserDto userDto = userService.readById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/zxc/{id}")
    public ResponseEntity<UserDto> readById1(@PathVariable UUID id) {
        UserDto userDto = userService.readById1(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody User user) {
        UserDto userDtoCreated = userService.create(user);
        return new ResponseEntity<>(userDtoCreated, HttpStatus.CREATED);
    }

//    public ResponseEntity<UserDto> update()
}
