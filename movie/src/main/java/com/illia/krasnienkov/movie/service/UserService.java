package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.RoleDto;
import com.illia.krasnienkov.movie.dto.UserDto;
import com.illia.krasnienkov.movie.model.Role;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
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

    public UserDto readById(String id) {
        String formattedId = id.replace("-", "");
        User user = userRepository.namedFindUserById(formattedId);
        return service.convert(user, UserDto.class);
    }

    public UserDto readById1(UUID id) {
        User user = userRepository.findById(id).get();
        return service.convert(user, UserDto.class);
    }

    public UserDto create(User user) {
//        // if role not found -> give user role and warn
//        convertRoles(user, userDto);
//        User createdUser = userRepository.save(convertedUser);
//        UserDto newUserDto = service.convert(createdUser, UserDto.class);
//        return newUserDto;
    }

    public List<UserDto> readAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> service.convert(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto update(User user){

    }

    private void convertUser(){

    }

    private void convertRoles(User convertedUser, UserDto userDto) {
        Set<RoleDto> roleDtoSet = userDto.getRoles();
        if (roleDtoSet.isEmpty()) {
            Role role = roleService.findByName("USER");
            convertedUser.setRoles(Set.of(role));
            return;
        }
        Set<String> roleNamesSet = roleDtoSet.stream()
                .map(RoleDto::getName)
                .collect(Collectors.toSet());
        Set<Role> roles = roleService.findByNameIn(roleNamesSet);
        convertedUser.setRoles(roles);
    }
}
