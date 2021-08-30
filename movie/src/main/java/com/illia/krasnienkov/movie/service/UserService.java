package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.UserDto;
import com.illia.krasnienkov.movie.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    UserDto create(User user);

    List<UserDto> readAll();

    UserDto readById(String id);

    UserDto readById1(String id);

    UserDto update(User user);

    UserDto patch(Map<String, Object> fields, String id);

    void deleteById(String id);
}
