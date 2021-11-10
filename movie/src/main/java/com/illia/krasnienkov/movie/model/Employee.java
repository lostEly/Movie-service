package com.illia.krasnienkov.movie.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "employee")
public class Employee extends Audit {

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 40)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!name.equals(employee.name)) return false;
        if (!lastName.equals(employee.lastName)) return false;
        return professions.equals(employee.professions);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + professions.hashCode();
        return result;
    }
}
