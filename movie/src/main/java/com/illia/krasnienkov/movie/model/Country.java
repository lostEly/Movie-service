package com.illia.krasnienkov.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "country")
public class Country extends Audit {
    @Column(nullable = false)
    private String shortName;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, length = 2)
    private String alpha2;

    @Column(nullable = false, length = 3, unique = true)
    private Integer ISO;

    @Column(nullable = false)
    private String partOfTheWorld;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (shortName != null ? !shortName.equals(country.shortName) : country.shortName != null) return false;
        if (fullName != null ? !fullName.equals(country.fullName) : country.fullName != null) return false;
        if (!alpha2.equals(country.alpha2)) return false;
        if (!ISO.equals(country.ISO)) return false;
        return partOfTheWorld != null ? partOfTheWorld.equals(country.partOfTheWorld) : country.partOfTheWorld == null;
    }

    @Override
    public int hashCode() {
        int result = alpha2.hashCode();
        result = 31 * result + ISO.hashCode();
        return result;
    }
}
