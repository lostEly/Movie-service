package com.softserveinc.illia.krasnienkov.movie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "movie_list")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieListId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime dateAdded;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Enumerated(EnumType.STRING)
    private MovieListType movieListType;

    @OneToMany(mappedBy = "movieList")
    private List<MovieListToMovie> movieListToMovies;

    public enum MovieListType {
        WILL, WATCHED, FAVOURITE, CUSTOM
    }
}



