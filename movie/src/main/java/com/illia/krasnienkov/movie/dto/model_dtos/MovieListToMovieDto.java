package com.illia.krasnienkov.movie.dto.model_dtos;

import com.illia.krasnienkov.movie.dto.CommonDto;

import java.time.LocalDateTime;

public class MovieListToMovieDto extends CommonDto {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieListToMovieDto that = (MovieListToMovieDto) o;

        if (!movieListDto.equals(that.movieListDto)) return false;
        if (!movieDto.equals(that.movieDto)) return false;
        return dateAdded.equals(that.dateAdded);
    }

    @Override
    public int hashCode() {
        int result = movieListDto.hashCode();
        result = 31 * result + movieDto.hashCode();
        result = 31 * result + dateAdded.hashCode();
        return result;
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
