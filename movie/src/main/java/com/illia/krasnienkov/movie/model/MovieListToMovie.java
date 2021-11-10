package com.illia.krasnienkov.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity(name = "movie_list_to_movie")
public class MovieListToMovie extends Audit {

    @ManyToOne
    @JoinColumn(name = "movie_list_id")
    private MovieList movieList;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(nullable = false)
    private LocalDate dateAdded;

    public MovieList getMovieList() {
        return movieList;
    }

    public void setMovieList(MovieList movieList) {
        this.movieList = movieList;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieListToMovie that = (MovieListToMovie) o;

        if (movieList != null ? !movieList.equals(that.movieList) : that.movieList != null) return false;
        if (movie != null ? !movie.equals(that.movie) : that.movie != null) return false;
        return dateAdded != null ? dateAdded.equals(that.dateAdded) : that.dateAdded == null;
    }

    @Override
    public int hashCode() {
        int result = movieList != null ? movieList.hashCode() : 0;
        result = 31 * result + (movie != null ? movie.hashCode() : 0);
        result = 31 * result + (dateAdded != null ? dateAdded.hashCode() : 0);
        return result;
    }
}
