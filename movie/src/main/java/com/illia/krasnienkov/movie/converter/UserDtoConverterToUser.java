package com.illia.krasnienkov.movie.converter;

import com.illia.krasnienkov.movie.dto.UserDto;
import com.illia.krasnienkov.movie.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class UserDtoConverterToUser implements Converter<UserDto, User> {
    private static final DateTimeFormatter dateFormat
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setSex(User.Sex.valueOf(userDto.getSex()));
        user.setEmail(userDto.getEmail());
        user.setDateOfBirthday(LocalDate.parse(userDto.getDateOfBirthday(), dateFormat));
        user.setRole(userDto.getRole());
        user.setTelephone(userDto.getTelephone());
        return user;
    }
}
