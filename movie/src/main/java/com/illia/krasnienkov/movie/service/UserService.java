package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.UserDto;
import com.illia.krasnienkov.movie.model.Role;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;
    private ConversionService service;
    private RoleService roleService;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public UserDto create(User user) {
        convertRoles(user);
        User createdUser = userRepository.save(user);
        UserDto newUserDto = service.convert(createdUser, UserDto.class);
        return newUserDto;
    }

    public List<UserDto> readAll() {
        List<User> users = userRepository.findAll();
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
        User user = userRepository.findById(id).get();
        return service.convert(user, UserDto.class);
    }

    public UserDto update(User user) {
        if (user.getId() == null)
            throw new RuntimeException("UserId == null");
        User updatedUser = userRepository.save(user);
        return service.convert(updatedUser, UserDto.class);
    }

    public UserDto patch(Map<String, Object> fields, UUID id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(User.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, user, v);
        });
        User patchedUser = userRepository.save(user);
        return service.convert(patchedUser, UserDto.class);
    }

    public void deleteById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("User with id " + id + " not found");
        }
        userRepository.deleteById(id);
    }

    private void convertRoles(User convertedUser) {
        Set<String> roleNames = convertedUser.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
        Set<Role> roles = roleService.findByNameIn(roleNames); //if role not found -> give user role and warn
        if (!roles.isEmpty()) {
            convertedUser.setRoles(roles);
            return;
        }
        Role role = roleService.findByName("USER");
        convertedUser.setRoles(Set.of(role));
    }
}
