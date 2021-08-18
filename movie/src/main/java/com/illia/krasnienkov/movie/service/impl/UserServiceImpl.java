package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.UserDto;
import com.illia.krasnienkov.movie.model.Role;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.repository.UserRepository;
import com.illia.krasnienkov.movie.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
    private UserRepository userRepository;
    private ConversionService service;
    private RoleServiceImpl roleService;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Autowired
    public void setRoleService(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    public UserDto create(User user) {
        LOGGER.info("Started creating user");
        convertRoles(user);
        User createdUser = userRepository.save(user);
        UserDto newUserDto = service.convert(createdUser, UserDto.class);
        LOGGER.info("Created user");
        return newUserDto;
    }

    public List<UserDto> readAll() {
        LOGGER.info("Started reading all users");
        List<User> users = userRepository.findAll();
        LOGGER.info("Read all users");
        return users.stream()
                .map(user -> service.convert(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto readById(String id) {
        String formattedId = id.replace("-", "");
        User user = userRepository.namedFindUserById(formattedId);
        return service.convert(user, UserDto.class);
    }

    public UserDto readById1(UUID id) {
        User user = findUserById(id);
        return service.convert(user, UserDto.class);
    }

    public UserDto update(User user) {
        LOGGER.warn("Started updating user with id + " + user.getId());
        if (user.getId() == null)
            throw new RuntimeException("UserId == null");
        User updatedUser = userRepository.save(user);
        LOGGER.info("User with id + " + user.getId() + " is updated");
        return service.convert(updatedUser, UserDto.class);
    }

    public UserDto patch(Map<String, Object> fields, UUID id) {
        LOGGER.warn("Started patching user with id + " + id);
        User user = findUserById(id);
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(User.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, user, v);
        });
        User patchedUser = userRepository.save(user);
        LOGGER.info("User with id + " + user.getId() + " is patched");
        return service.convert(patchedUser, UserDto.class);
    }

    public void deleteById(UUID id) {
        LOGGER.warn("Started deleting user with id " + id);
        User user = findUserById(id);
        userRepository.delete(user);
        LOGGER.info("Finished deleting user with id " + id);
    }

    private User findUserById(UUID id) {
        LOGGER.info("Started reading user by id");
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            LOGGER.error("User with id + " + id + " not found");
            throw new RuntimeException();
        }
        User user = optionalUser.get();
        LOGGER.info("Finished reading user by id");
        return user;
    }

    private void convertRoles(User convertedUser) {
        LOGGER.info("Started converting roles for user with id " + convertedUser.getId());
        Set<String> roleNames = convertedUser.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
        Set<Role> roles = roleService.findByNameIn(roleNames); //if role not found -> give user role and warn
        if (!roles.isEmpty()) {
            convertedUser.setRoles(roles);
            LOGGER.info("Roles are set");
            return;
        }
        LOGGER.error("No matching roles found. Setting default user role");
        Role role = roleService.findByName("USER");
        LOGGER.info("User role is set");
        convertedUser.setRoles(Set.of(role));
    }
}
