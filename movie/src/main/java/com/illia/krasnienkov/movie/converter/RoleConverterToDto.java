package com.illia.krasnienkov.movie.converter;

import com.illia.krasnienkov.movie.dto.RoleDto;
import com.illia.krasnienkov.movie.model.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverterToDto implements Converter<Role, RoleDto> {

    @Override
    public RoleDto convert(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleId(role.getId().toString());
        roleDto.setName(role.getName());
        return roleDto;
    }
}
