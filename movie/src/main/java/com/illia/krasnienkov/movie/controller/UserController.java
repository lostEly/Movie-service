package com.illia.krasnienkov.movie.controller;

import com.illia.krasnienkov.movie.dto.UserDto;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody User user) {
        UserDto userDtoCreated = userService.create(user);
        return new ResponseEntity<>(userDtoCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> readAll() {
        List<UserDto> userDtoList = userService.readAll();
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
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

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody User user) {
        UserDto updatedUser = userService.update(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> patch(@RequestBody Map<String, Object> fields, @PathVariable UUID id) {
        UserDto userDto = userService.patch(fields, id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
