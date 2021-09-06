package com.illia.krasnienkov.movie.converter;

import com.illia.krasnienkov.movie.dto.model_dtos.RoleDto;
import com.illia.krasnienkov.movie.model.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RoleConverterToDto implements Converter<Role, RoleDto> {

    @Override
    public RoleDto convert(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleId(UUID.fromString(role.getId()));
        roleDto.setName(role.getName());
        return roleDto;
    }
}
