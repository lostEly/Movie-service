package com.illia.krasnienkov.movie.converter;

import com.illia.krasnienkov.movie.dto.UserDto;
import com.illia.krasnienkov.movie.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverterToDto implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        dto.setSex(user.getSex().toString());
        dto.setEmail(user.getEmail());
        dto.setDateOfBirthday(user.getDateOfBirthday().toString());
        dto.setRole(user.getRole());
        dto.setTelephone(user.getTelephone());
        return dto;
    }
}
