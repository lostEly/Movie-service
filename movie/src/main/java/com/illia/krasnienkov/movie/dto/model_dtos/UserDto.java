package com.illia.krasnienkov.movie.dto.model_dtos;

import com.illia.krasnienkov.movie.dto.CommonDto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserDto extends CommonDto {

    private String name;
    private String lastName;
    private String sex;
    private String dateOfBirthday;
    private String telephone;
    private String email;
    private Set<RoleDto> roles = new HashSet<>();

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        if (!getId().equals(userDto.getId())) return false;
        if (!name.equals(userDto.name)) return false;
        if (!lastName.equals(userDto.lastName)) return false;
        if (sex != null ? !sex.equals(userDto.sex) : userDto.sex != null) return false;
        if (dateOfBirthday != null ? !dateOfBirthday.equals(userDto.dateOfBirthday) : userDto.dateOfBirthday != null)
            return false;
        if (!telephone.equals(userDto.telephone)) return false;
        return email.equals(userDto.email);
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (dateOfBirthday != null ? dateOfBirthday.hashCode() : 0);
        result = 31 * result + telephone.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", dateOfBirthday=" + dateOfBirthday +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
