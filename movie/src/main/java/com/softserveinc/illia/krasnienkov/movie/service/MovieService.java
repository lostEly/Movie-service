package com.softserveinc.illia.krasnienkov.movie.service;

import com.softserveinc.illia.krasnienkov.movie.dto.MovieDto;
import com.softserveinc.illia.krasnienkov.movie.model.Movie;
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

    public void test(Movie movie){
        System.out.println(service.convert(movie, MovieDto.class));
    }

}
