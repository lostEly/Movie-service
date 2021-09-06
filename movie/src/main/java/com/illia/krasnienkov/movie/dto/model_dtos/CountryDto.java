package com.illia.krasnienkov.movie.dto.model_dtos;

public class CountryDto {
    private String shortName;

    private String fullName;

    private String alpha2;

    private Integer ISO;

    private String partOfTheWorld;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public Integer getISO() {
        return ISO;
    }

    public void setISO(Integer ISO) {
        this.ISO = ISO;
    }

    public String getPartOfTheWorld() {
        return partOfTheWorld;
    }

    public void setPartOfTheWorld(String partOfTheWorld) {
        this.partOfTheWorld = partOfTheWorld;
    }
}
