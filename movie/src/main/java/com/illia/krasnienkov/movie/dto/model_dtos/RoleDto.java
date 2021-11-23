package com.illia.krasnienkov.movie.dto.model_dtos;

import com.illia.krasnienkov.movie.dto.CommonDto;

import java.util.UUID;

public class RoleDto extends CommonDto {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleDto roleDto = (RoleDto) o;

        if (!getId().equals(roleDto.getId())) return false;
        return name.equals(roleDto.name);
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "roleId='" + getId() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
