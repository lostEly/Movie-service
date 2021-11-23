package com.illia.krasnienkov.movie.dto.model_dtos;

import com.illia.krasnienkov.movie.dto.CommonDto;

public class CountryDto extends CommonDto {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryDto that = (CountryDto) o;

        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (!alpha2.equals(that.alpha2)) return false;
        if (!ISO.equals(that.ISO)) return false;
        return partOfTheWorld != null ? partOfTheWorld.equals(that.partOfTheWorld) : that.partOfTheWorld == null;
    }

    @Override
    public int hashCode() {
        int result = alpha2.hashCode();
        result = 31 * result + ISO.hashCode();
        return result;
    }
}
