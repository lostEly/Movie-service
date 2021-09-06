package com.illia.krasnienkov.movie.controller;

import com.illia.krasnienkov.movie.dto.model_dtos.MovieListDto;
import com.illia.krasnienkov.movie.model.MovieList;
import com.illia.krasnienkov.movie.service.impl.MovieListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movie-lists")
public class MovieListController {
    private MovieListServiceImpl movieListServiceImpl;

    @Autowired
    public void setMovieListService(MovieListServiceImpl movieListServiceImpl) {
        this.movieListServiceImpl = movieListServiceImpl;
    }

    @PostMapping
    public ResponseEntity<MovieListDto> create(@RequestBody MovieList movieList) {
        MovieListDto movieListDtoCreated = movieListServiceImpl.create(movieList);
        return new ResponseEntity<>(movieListDtoCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MovieListDto>> readAll() {
        List<MovieListDto> movieListDtoList = movieListServiceImpl.readAll();
        return new ResponseEntity<>(movieListDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieListDto> readById(@PathVariable String id) {
        MovieListDto movieListDto = movieListServiceImpl.readById(id);
        return new ResponseEntity<>(movieListDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MovieListDto> update(@RequestBody MovieList movieList) {
        MovieListDto updatedMovieList = movieListServiceImpl.update(movieList);
        return new ResponseEntity<>(updatedMovieList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MovieListDto> patch(@RequestBody Map<String, Object> fields, @PathVariable String id) {
        MovieListDto movieListDto = movieListServiceImpl.patch(fields, id);
        return new ResponseEntity<>(movieListDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        movieListServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
