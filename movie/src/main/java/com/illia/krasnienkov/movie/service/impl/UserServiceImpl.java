package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.model_dtos.RoleDto;
import com.illia.krasnienkov.movie.dto.model_dtos.UserDto;
import com.illia.krasnienkov.movie.exceptions.ResourceNotFoundException;
import com.illia.krasnienkov.movie.model.Role;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.repository.UserRepository;
import com.illia.krasnienkov.movie.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ModelsServiceImpl<UserDto, User> implements UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository = (UserRepository) this.repository;
    private RoleServiceImpl roleService;

    @Autowired
    protected UserServiceImpl(@Qualifier("userRepository") JpaRepository<User, String> repository, ConversionService service) {
        super(repository, service, UserDto.class, User.class);
    }

    @Autowired
    public void setRoleService(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @Override
    public UserDto create(User user) {
        LOGGER.info("Started creating user");
        convertRoles(user);
        User createdUser = userRepository.save(user);
        UserDto newUserDto = service.convert(createdUser, UserDto.class);
        LOGGER.info("Created user");
        return newUserDto;
    }

    public UserDto readById(String id) {
        User user = findById(id);
        return service.convert(user, UserDto.class);
    }

    @Override
    public UserDto update(User user) {
        LOGGER.warn("Started updating user with id + " + user.getId());
        if (user.getId() == null)
            throw new RuntimeException("UserId == null");
        convertRoles(user);
        User updatedUser = userRepository.save(user);
        LOGGER.info("User with id + " + user.getId() + " is updated");
        return service.convert(updatedUser, UserDto.class);
    }

    private void convertRoles(User convertedUser) {
        LOGGER.info("Started converting roles for user with id " + convertedUser.getId());
        Set<String> roleNames = convertedUser.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
        Set<RoleDto> roleDtoSet;
        Set<Role> roles;
        try {
            roleDtoSet = roleService.findByNameIn(roleNames);
            roles = roleDtoSet.stream()
                    .map(roleDto -> service.convert(roleDto, Role.class))
                    .collect(Collectors.toSet());
        } catch (ResourceNotFoundException exception) {
            LOGGER.error("No matching roles found. Setting default user role");
            Role role = roleService.findByName("USER");
            LOGGER.info("User role is set");
            convertedUser.setRoles(Set.of(role));
            return;
        }
        convertedUser.setRoles(roles);
        LOGGER.info("Roles are set");
    }
}
