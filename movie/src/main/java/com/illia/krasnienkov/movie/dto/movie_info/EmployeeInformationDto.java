package com.illia.krasnienkov.movie.dto.movie_info;

import java.util.Set;

public class EmployeeInformationDto {
    private String employeeName;
    private String employeeLastName;
    private Set<String> professions;

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

    public Set<String> getProfessions() {
        return professions;
    }

    public void setProfessions(Set<String> professions) {
        this.professions = professions;
    }
}
