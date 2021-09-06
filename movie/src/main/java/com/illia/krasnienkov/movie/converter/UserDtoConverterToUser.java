package com.illia.krasnienkov.movie.converter;

import com.illia.krasnienkov.movie.dto.model_dtos.UserDto;
import com.illia.krasnienkov.movie.model.Role;
import com.illia.krasnienkov.movie.model.User;
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

    private RoleDtoConverterToRole roleDtoConverterToRole;

    @Autowired
    public void setService(RoleDtoConverterToRole roleDtoConverterToRole) {
        this.roleDtoConverterToRole = roleDtoConverterToRole;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId().toString());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setSex(User.Sex.valueOf(userDto.getSex()));
        user.setEmail(userDto.getEmail());
        user.setDateOfBirthday(LocalDate.parse(userDto.getDateOfBirthday(), dateFormat));
        user.setTelephone(userDto.getTelephone());

        Set<Role> roles = userDto.getRoles()
                .stream()
                .map(roleDto -> roleDtoConverterToRole.convert(roleDto))
                .collect(Collectors.toSet());
        user.setRoles(roles);
        return user;
    }
}
