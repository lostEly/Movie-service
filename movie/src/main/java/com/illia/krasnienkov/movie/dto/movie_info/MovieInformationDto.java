package com.illia.krasnienkov.movie.dto.movie_info;

import java.time.LocalDate;
import java.util.Set;

public class MovieInformationDto {
    private String movieName;
    private String description;
    private String duration;
    private Double rating;
    private LocalDate releaseDate;
    private Set<String> genreName;
    private Set<String> countryName;
    private Set<EmployeeInformationDto> employees;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<String> getGenreName() {
        return genreName;
    }

    public void setGenreName(Set<String> genreName) {
        this.genreName = genreName;
    }

    public Set<String> getCountryName() {
        return countryName;
    }

    public void setCountryName(Set<String> countryName) {
        this.countryName = countryName;
    }

    public Set<EmployeeInformationDto> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeInformationDto> employees) {
        this.employees = employees;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieInformationDto that = (MovieInformationDto) o;

        if (!movieName.equals(that.movieName)) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (!duration.equals(that.duration)) return false;
        if (!rating.equals(that.rating)) return false;
        return releaseDate.equals(that.releaseDate);
    }

    @Override
    public int hashCode() {
        int result = movieName.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + duration.hashCode();
        result = 31 * result + rating.hashCode();
        result = 31 * result + releaseDate.hashCode();
        return result;
    }

}
