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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeInformationDto that = (EmployeeInformationDto) o;

        if (!employeeName.equals(that.employeeName)) return false;
        if (!employeeLastName.equals(that.employeeLastName)) return false;
        return professions != null ? professions.equals(that.professions) : that.professions == null;
    }

    @Override
    public int hashCode() {
        int result = employeeName.hashCode();
        result = 31 * result + employeeLastName.hashCode();
        result = 31 * result + (professions != null ? professions.hashCode() : 0);
        return result;
    }
}
