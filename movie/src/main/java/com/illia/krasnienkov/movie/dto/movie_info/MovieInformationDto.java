package com.illia.krasnienkov.movie.dto.movie_info;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;


@SqlResultSetMapping(name = "MovieInfo",
        entities = {
                @EntityResult(entityClass = MovieInformationDto.class, fields = {
                        @FieldResult(name = "movieName", column = "movie_name"),
                        @FieldResult(name = "description", column = "description"),
                        @FieldResult(name = "duration", column = "duration"),
                        @FieldResult(name = "rating", column = "rating"),
                        @FieldResult(name = "releaseDate", column = "release_date"),
                        @FieldResult(name = "genreName", column = "genre_name")
                }),
                @EntityResult(entityClass = EmployeeInformationDto.class, fields = {
                        @FieldResult(name = "employeeName", column = "employee_name"),
                        @FieldResult(name = "employeeLastName", column = "employee_last_name"),
                        @FieldResult(name = "professionName", column = "profession")
                })
        })
public class MovieInformationDto {
    private String movieName;
    private String description;
    private Duration duration;
    private Double rating;
    private LocalDate releaseDate;
    private List<String> genreName;
    private List<String> countryName;
    private List<EmployeeInformationDto> employees;

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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
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

    public List<String> getGenreName() {
        return genreName;
    }

    public void setGenreName(List<String> genreName) {
        this.genreName = genreName;
    }

    public List<String> getCountryName() {
        return countryName;
    }

    public void setCountryName(List<String> countryName) {
        this.countryName = countryName;
    }

    public List<EmployeeInformationDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeInformationDto> employees) {
        this.employees = employees;
    }
}
