package com.illia.krasnienkov.movie.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "movie_list")
public class MovieList extends Audit {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime dateCreated;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Enumerated(EnumType.STRING)
    private MovieListType movieListType;

    @OneToMany(mappedBy = "movieList")
    private List<MovieListToMovie> movieListToMovies;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MovieListType getMovieListType() {
        return movieListType;
    }

    public void setMovieListType(MovieListType movieListType) {
        this.movieListType = movieListType;
    }

    public List<MovieListToMovie> getMovieListToMovies() {
        return movieListToMovies;
    }

    @Override
    public String toString() {
        return "MovieList{" +
                "name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", comment='" + comment + '\'' +
                ", user=" + user +
                ", movieListType=" + movieListType +
                '}';
    }

    public enum MovieListType {
        WILL, WATCHED, FAVOURITE, CUSTOM
    }
}
