package com.softserveinc.illia.krasnienkov.movie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "movie_list_to_movie")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieListToMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieListToMovieId;

    @ManyToOne
    @JoinColumn(name = "movie_list_id")
    private MovieList movieList;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(nullable = false)
    private LocalDate dateCreated;
}
