package com.softserveinc.illia.krasnienkov.movie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity(name = "movie")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @ManyToMany
    @JoinTable(
            name = "genre_to_movie",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Genre> genres;

    @OneToMany(mappedBy = "movie")
    private List<MovieListToMovie> movieListToMovies;

}
