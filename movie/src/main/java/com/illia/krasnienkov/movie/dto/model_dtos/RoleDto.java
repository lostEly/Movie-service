package com.illia.krasnienkov.movie.dto.model_dtos;

import java.util.UUID;

public class RoleDto {

    private UUID roleId;
    private String name;

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

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

        if (!roleId.equals(roleDto.roleId)) return false;
        return name.equals(roleDto.name);
    }

    @Override
    public int hashCode() {
        int result = roleId.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "roleId='" + roleId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
