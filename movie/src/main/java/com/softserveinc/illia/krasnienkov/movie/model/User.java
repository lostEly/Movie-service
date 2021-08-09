package com.softserveinc.illia.krasnienkov.movie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "userr")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User  extends Audit{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sex sex;

    @Column(nullable = false)
    private LocalDate dateOfBirthday;

    @Column(unique = true, nullable = false)
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String telephone;

    @Email
    @Column(nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    @OneToMany
    private List<MovieList> movieLists = new ArrayList<>();

    public void addMovieList(MovieList movieList) {
        movieList.setUser(this);
        this.movieLists.add(movieList);
    }

    public void removeMovieList(MovieList movieList) {
        movieList.setUser(null);
        this.movieLists.remove(movieList);
    }

    public enum Sex {
        MALE, FEMALE
    }
}
