package com.illia.krasnienkov.movie.converter;

import com.illia.krasnienkov.movie.dto.RoleDto;
import com.illia.krasnienkov.movie.dto.UserDto;
import com.illia.krasnienkov.movie.model.Role;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserDtoConverterToUser implements Converter<UserDto, User> {

    private static final DateTimeFormatter dateFormat
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setSex(User.Sex.valueOf(userDto.getSex()));
        user.setEmail(userDto.getEmail());
        user.setDateOfBirthday(LocalDate.parse(userDto.getDateOfBirthday(), dateFormat));
        user.setTelephone(userDto.getTelephone());

//        Set<Role> roles = new HashSet<>();
//        for (RoleDto roleDto : roleNamesSet) {
//            roles.add(service.convert(roleDto, Role.class));
//        }
//        user.setRoles(roles);
//        user.setRoles(roleNamesSet.stream()
//                .map(obj -> service.convert(obj, Role.class))
//                .collect(Collectors.toSet()));
        return user;
    }
}
