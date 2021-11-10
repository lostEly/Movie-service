package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.model_dtos.UserDto;
import com.illia.krasnienkov.movie.model.User;

import java.util.List;
import java.util.Map;

public interface UserService extends ModelsService<UserDto, User> {
    @Override
    UserDto create(User user);

    @Override
    List<UserDto> readAll();

    @Override
    UserDto readById(String id);

    @Override
    UserDto update(User user);

    @Override
    UserDto patch(Map<String, Object> fields, String id);

    @Override
    void deleteById(String id);
}
