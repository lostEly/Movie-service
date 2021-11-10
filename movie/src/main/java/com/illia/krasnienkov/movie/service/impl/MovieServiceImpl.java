package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.model_dtos.MovieDto;
import com.illia.krasnienkov.movie.dto.movie_info.EmployeeInformationDto;
import com.illia.krasnienkov.movie.dto.movie_info.MovieInformationDto;
import com.illia.krasnienkov.movie.dto.movie_info.MovieInformationRow;
import com.illia.krasnienkov.movie.model.Movie;
import com.illia.krasnienkov.movie.repository.MovieRepository;
import com.illia.krasnienkov.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private ConversionService service;
    private MovieRepository movieRepository;

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieDto create(Movie movie) {
        return null;
    }

    @Override
    public List<MovieDto> readAll() {
        return movieRepository.findAll()
                .stream()
                .map(movie -> service.convert(movie,MovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto readById(String id) {
        return null;
    }

    @Override
    public MovieDto update(Movie movie) {
        return null;
    }

    @Override
    public MovieDto patch(Map<String, Object> fields, String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public MovieDto getRandomMovie() {
        Movie randomMovie = movieRepository.namedGetRandomMovie();
        return service.convert(randomMovie, MovieDto.class);
    }

    public MovieInformationDto getMovieInformation(String id) {
        List<MovieInformationRow> list = movieRepository.namedGetAllMovieInfo(id);
        MovieInformationRow row = list.get(0);
        MovieInformationDto movieInformationDto = new MovieInformationDto();
        movieInformationDto.setMovieName(row.getMovieName());
        movieInformationDto.setDescription(row.getDescription());
        movieInformationDto.setDuration(row.getDuration().toString());
        movieInformationDto.setRating(row.getRating());
        movieInformationDto.setReleaseDate(LocalDate.parse(row.getReleaseDate()));
        Set<String> genreNames = list.stream()
                .map(MovieInformationRow::getGenreName)
                .collect(Collectors.toSet());
        movieInformationDto.setGenreName(genreNames);
        Set<String> countryNames = list.stream()
                .map(MovieInformationRow::getCountryName)
                .collect(Collectors.toSet());
        movieInformationDto.setCountryName(countryNames);
        Set<EmployeeInformationDto> employeesInformation = list.stream()
                .map(info -> {
                    EmployeeInformationDto employeeInformationDto = new EmployeeInformationDto();
                    employeeInformationDto.setEmployeeName(info.getEmployeeName());
                    employeeInformationDto.setEmployeeLastName(info.getEmployeeLastName());
                    return employeeInformationDto;
                }).collect(Collectors.toSet());
        movieInformationDto.setEmployees(employeesInformation);
        return movieInformationDto;
    }


}
