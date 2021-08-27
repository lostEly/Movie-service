package com.illia.krasnienkov.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "profession")
public class Profession extends Audit {

    @Column(nullable = false, length = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
