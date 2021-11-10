package com.illia.krasnienkov.movie.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "genre")
public class Genre extends Audit {

    @Column(nullable = false, length = 30)
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getParentGenre() {
        return parentGenre;
    }

    public void setParentGenre(Genre parentGenre) {
        this.parentGenre = parentGenre;
    }

    public Set<Genre> getSubGenres() {
        return subGenres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (!name.equals(genre.name)) return false;
        return parentGenre.equals(genre.parentGenre);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + parentGenre.hashCode();
        return result;
    }
}
