package com.illia.krasnienkov.movie.dto;

import java.time.LocalDateTime;

public class MovieListToMovieDto {
    private MovieListDto movieListDto;
    private MovieDto movieDto;
    private LocalDateTime dateAdded;

    public MovieListDto getMovieListDto() {
        return movieListDto;
    }

    public void setMovieListDto(MovieListDto movieListDto) {
        this.movieListDto = movieListDto;
    }

    public MovieDto getMovieDto() {
        return movieDto;
    }

    public void setMovieDto(MovieDto movieDto) {
        this.movieDto = movieDto;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "MovieListToMovieDto{" +
                "movieListDto=" + movieListDto +
                ", movieDto=" + movieDto +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
