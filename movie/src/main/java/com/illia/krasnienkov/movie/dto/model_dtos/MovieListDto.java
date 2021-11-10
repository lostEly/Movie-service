package com.illia.krasnienkov.movie.dto.model_dtos;

import com.illia.krasnienkov.movie.model.MovieList;

import java.time.LocalDateTime;
import java.util.UUID;

public class MovieListDto {
    private UUID id;

    private String name;

    private LocalDateTime dateCreated;

    private String comment;

    private UserDto userDto;

    private MovieList.MovieListType movieListType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public MovieList.MovieListType getMovieListType() {
        return movieListType;
    }

    public void setMovieListType(MovieList.MovieListType movieListType) {
        this.movieListType = movieListType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieListDto that = (MovieListDto) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        return comment != null ? comment.equals(that.comment) : that.comment == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MovieListDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", comment='" + comment + '\'' +
                ", userDto=" + userDto +
                ", movieListType=" + movieListType +
                '}';
    }
}
