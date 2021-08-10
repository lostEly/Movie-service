package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.UserDto;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private ConversionService service;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    public UserDto readById(String id) {
        User user = userRepository.namedFindUserById(id);
        return service.convert(user, UserDto.class);
    }

    public void create(UserDto userDto) {
        User user = service.convert(userDto, User.class);
        userRepository.save(user);
    }
}
