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

    @Column(nullable = false, length = 3)
    private Integer ISO;

    @Column(nullable = false)
    private String partOfTheWorld;
}
