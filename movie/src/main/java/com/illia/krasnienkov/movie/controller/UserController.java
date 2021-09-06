package com.illia.krasnienkov.movie.controller;

import com.illia.krasnienkov.movie.dto.model_dtos.UserDto;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserServiceImpl userServiceImpl;

    @Autowired
    public void setUserService(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody User user) {
        UserDto userDtoCreated = userServiceImpl.create(user);
        return new ResponseEntity<>(userDtoCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> readAll() {
        List<UserDto> userDtoList = userServiceImpl.readAll();
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> readById(@PathVariable String id) {
        UserDto userDto = userServiceImpl.readById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/zxc/{id}")
    public ResponseEntity<UserDto> readById1(@PathVariable String id) {
        UserDto userDto = userServiceImpl.readById1(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody User user) {
        UserDto updatedUser = userServiceImpl.update(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> patch(@RequestBody Map<String, Object> fields, @PathVariable String id) {
        UserDto userDto = userServiceImpl.patch(fields, id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        userServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
