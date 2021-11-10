package com.illia.krasnienkov.movie.dto.movie_info;

import java.time.Duration;

public class MovieInformationRow {
    private String movieName;
    private String description;
    private Duration duration;
    private Double rating;
    private String releaseDate;
    private String genreName;
    private String countryName;
    private String employeeName;
    private String employeeLastName;
    private String professionName;

    public MovieInformationRow(String movieName, String description, Duration duration, Double rating, String releaseDate, String genreName, String countryName, String employeeName, String employeeLastName, String professionName) {
        this.movieName = movieName;
        this.description = description;
        this.duration = duration;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.genreName = genreName;
        this.countryName = countryName;
        this.employeeName = employeeName;
        this.employeeLastName = employeeLastName;
        this.professionName = professionName;
    }

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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieInformationRow that = (MovieInformationRow) o;

        if (!movieName.equals(that.movieName)) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (!duration.equals(that.duration)) return false;
        if (!rating.equals(that.rating)) return false;
        if (!releaseDate.equals(that.releaseDate)) return false;
        if (genreName != null ? !genreName.equals(that.genreName) : that.genreName != null) return false;
        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;
        if (employeeName != null ? !employeeName.equals(that.employeeName) : that.employeeName != null) return false;
        if (employeeLastName != null ? !employeeLastName.equals(that.employeeLastName) : that.employeeLastName != null)
            return false;
        return professionName != null ? professionName.equals(that.professionName) : that.professionName == null;
    }

    @Override
    public int hashCode() {
        int result = movieName.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + duration.hashCode();
        result = 31 * result + rating.hashCode();
        result = 31 * result + releaseDate.hashCode();
        result = 31 * result + (genreName != null ? genreName.hashCode() : 0);
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (employeeName != null ? employeeName.hashCode() : 0);
        result = 31 * result + (employeeLastName != null ? employeeLastName.hashCode() : 0);
        result = 31 * result + (professionName != null ? professionName.hashCode() : 0);
        return result;
    }
}
