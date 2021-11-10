package com.illia.krasnienkov.movie.dto.model_dtos;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class MovieDto {

    private UUID movieId;
    private String name;
    private String description;
    private Duration duration;
    private LocalDate releaseDate;
    private Double rating;

    public UUID getMovieId() {
        return movieId;
    }

    public void setMovieId(UUID movieId) {
        this.movieId = movieId;
    }

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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
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

    @Override
    public String toString() {
        return "MovieDto{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieDto movieDto = (MovieDto) o;

        if (!movieId.equals(movieDto.movieId)) return false;
        if (!name.equals(movieDto.name)) return false;
        if (description != null ? !description.equals(movieDto.description) : movieDto.description != null)
            return false;
        if (!duration.equals(movieDto.duration)) return false;
        if (releaseDate != null ? !releaseDate.equals(movieDto.releaseDate) : movieDto.releaseDate != null)
            return false;
        return rating.equals(movieDto.rating);
    }

    @Override
    public int hashCode() {
        int result = movieId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + rating.hashCode();
        return result;
    }
}
