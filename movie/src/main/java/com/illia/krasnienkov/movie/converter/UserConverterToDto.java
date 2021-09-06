package com.illia.krasnienkov.movie.converter;

import com.illia.krasnienkov.movie.dto.model_dtos.RoleDto;
import com.illia.krasnienkov.movie.dto.model_dtos.UserDto;
import com.illia.krasnienkov.movie.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserConverterToDto implements Converter<User, UserDto> {

    private RoleConverterToDto roleConverterToDto;

    @Autowired
    public void setService(RoleConverterToDto roleConverterToDto) {
        this.roleConverterToDto = roleConverterToDto;
    }


    @Override
    public UserDto convert(User user) {
        UserDto dto = new UserDto();
        dto.setId(UUID.fromString(user.getId()));
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        dto.setSex(user.getSex().toString());
        dto.setEmail(user.getEmail());
        dto.setDateOfBirthday(user.getDateOfBirthday().toString());
        dto.setTelephone(user.getTelephone());

        Set<RoleDto> roles = user.getRoles()
                .stream()
                .map((role) -> roleConverterToDto.convert(role))
                .collect(Collectors.toSet());
        dto.setRoles(roles);
        return dto;
    }
}
