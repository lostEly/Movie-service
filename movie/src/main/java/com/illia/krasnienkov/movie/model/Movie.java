package com.illia.krasnienkov.movie.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity(name = "movie")
public class Movie extends Audit {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalTime duration;

    @Column(nullable = false)
    private LocalDate releaseDate;

    private Double rating;

    @ManyToMany
    @JoinTable(
            name = "employee_to_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> employees;

    @Enumerated(value = EnumType.STRING)
    private Country country;

    @ManyToMany
    @JoinTable(
            name = "genre_to_movie",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Genre> genres;

    @OneToMany(mappedBy = "movie")
    private List<MovieListToMovie> movieListToMovies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setMovieListToMovies(List<MovieListToMovie> movieListToMovies) {
        this.movieListToMovies = movieListToMovies;
    }

    public enum Country {
        USA, RUSSIA
    }
}
