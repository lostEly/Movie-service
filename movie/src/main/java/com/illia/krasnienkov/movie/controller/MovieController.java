package com.illia.krasnienkov.movie.controller;

import com.illia.krasnienkov.movie.dto.model_dtos.MovieDto;
import com.illia.krasnienkov.movie.dto.movie_info.MovieInformationDto;
import com.illia.krasnienkov.movie.model.Movie;
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

    private MovieServiceImpl movieServiceImpl;

    @Autowired
    public void setMovieService(MovieServiceImpl movieServiceImpl) {
        this.movieServiceImpl = movieServiceImpl;
    }

    @PostMapping
    public ResponseEntity<MovieDto> create(@RequestBody Movie movie) {
        MovieDto movieDtoCreated = movieServiceImpl.create(movie);
        return new ResponseEntity<>(movieDtoCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> readAll() {
        List<MovieDto> movieDtoList = movieServiceImpl.readAll();
        return new ResponseEntity<>(movieDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> readById(@PathVariable String id) {
        MovieDto movieDto = movieServiceImpl.readById(id);
        return new ResponseEntity<>(movieDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MovieDto> update(@RequestBody Movie movie) {
        MovieDto updatedMovie = movieServiceImpl.update(movie);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MovieDto> patch(@RequestBody Map<String, Object> fields, @PathVariable String id) {
        MovieDto movieDto = movieServiceImpl.patch(fields, id);
        return new ResponseEntity<>(movieDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        movieServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/random")
    public ResponseEntity<MovieDto> getRandomMovie(){
        MovieDto movieDto = movieServiceImpl.getRandomMovie();
        return new ResponseEntity<>(movieDto, HttpStatus.OK);
    }

    @GetMapping("/movie-info/{id}")
    public ResponseEntity<List<Object[]>> getMovieInformation(@PathVariable String id){
        List<Object[]> movieInformationDto = movieServiceImpl.getMovieInformation(id);
        return new ResponseEntity<>(movieInformationDto, HttpStatus.OK);
    }
}
