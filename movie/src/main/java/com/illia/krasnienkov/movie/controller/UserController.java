package com.illia.krasnienkov.movie.controller;

import com.illia.krasnienkov.movie.dto.UserDto;
import com.illia.krasnienkov.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        userService.create(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
}
