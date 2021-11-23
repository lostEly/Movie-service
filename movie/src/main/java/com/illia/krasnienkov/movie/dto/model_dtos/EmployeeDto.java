package com.illia.krasnienkov.movie.dto.model_dtos;

import com.illia.krasnienkov.movie.dto.CommonDto;

public class EmployeeDto extends CommonDto {

    private String name;

    private String lastName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeDto that = (EmployeeDto) o;

        if (!name.equals(that.name)) return false;
        return lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
}
