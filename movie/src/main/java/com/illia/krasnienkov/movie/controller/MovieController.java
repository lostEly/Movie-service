package com.illia.krasnienkov.movie.controller;

import com.illia.krasnienkov.movie.dto.model_dtos.MovieDto;
import com.illia.krasnienkov.movie.dto.movie_info.MovieInformationDto;
import com.illia.krasnienkov.movie.model.Movie;
import com.illia.krasnienkov.movie.service.MovieService;
import com.illia.krasnienkov.movie.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieDto> create(@RequestBody Movie movie) {
        MovieDto movieDtoCreated = movieService.create(movie);
        return new ResponseEntity<>(movieDtoCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> readAll() {
        List<MovieDto> movieDtoList = movieService.readAll();
        return new ResponseEntity<>(movieDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> readById(@PathVariable String id) {
        MovieDto movieDto = movieService.readById(id);
        return new ResponseEntity<>(movieDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MovieDto> update(@RequestBody Movie movie) {
        MovieDto updatedMovie = movieService.update(movie);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MovieDto> patch(@RequestBody Map<String, Object> fields, @PathVariable String id) {
        MovieDto movieDto = movieService.patch(fields, id);
        return new ResponseEntity<>(movieDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/random")
    public ResponseEntity<MovieDto> getRandomMovie(){
        MovieDto movieDto = movieService.getRandomMovie();
        return new ResponseEntity<>(movieDto, HttpStatus.OK);
    }

    @GetMapping("/movie-info/{id}")
    public ResponseEntity<MovieInformationDto> getMovieInformation(@PathVariable String id){
        MovieInformationDto movieInformationDto = movieService.getMovieInformation(id);
        return new ResponseEntity<>(movieInformationDto, HttpStatus.OK);
    }
}
