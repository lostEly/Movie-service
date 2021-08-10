package com.illia.krasnienkov.movie.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "employee")
public class Employee extends Audit {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "profession_to_employee",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "profession_id"))
    private Set<Profession> professions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Profession> getProfessions() {
        return professions;
    }
}
