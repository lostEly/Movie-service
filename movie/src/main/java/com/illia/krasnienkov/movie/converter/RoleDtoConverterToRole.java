package com.illia.krasnienkov.movie.converter;

import com.illia.krasnienkov.movie.dto.RoleDto;
import com.illia.krasnienkov.movie.model.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RoleDtoConverterToRole implements Converter<RoleDto, Role> {

    @Override
    public Role convert(RoleDto roleDto) {
        Role role = new Role();
        role.setId(roleDto.getRoleId().toString());
        role.setName(roleDto.getName());
        return role;
    }
}
