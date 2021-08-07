package com.softserveinc.illia.krasnienkov.movie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "genre")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genre parentGenre;

    @OneToMany(mappedBy = "parentGenre")
    private Set<Genre> subGenres = new HashSet<>();

    public Genre addSubGenre(String genreName) {
        Genre sub = new Genre();
        sub.setName(genreName);
        this.subGenres.add(sub);
        sub.setParentGenre(this);
        return sub;
    }

    public void moveGenre(Genre genre) {
        this.getParentGenre().getSubGenres().remove(this);
        this.setParentGenre(genre);
        genre.getSubGenres().add(this);
    }
}
