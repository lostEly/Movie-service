package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.MovieDto;
import com.illia.krasnienkov.movie.dto.UserDto;
import com.illia.krasnienkov.movie.model.Movie;
import com.illia.krasnienkov.movie.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private ConversionService service;

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    public void test(Movie movie) {
        System.out.println(service.convert(movie, MovieDto.class));
    }

    public void test2(UserDto userDto) {
        User user = service.convert(userDto, User.class);
        System.out.println(user.getRoles());
    }

}
