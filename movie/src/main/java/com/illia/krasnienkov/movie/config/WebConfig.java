package com.illia.krasnienkov.movie.config;

import com.illia.krasnienkov.movie.converter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private UserDtoConverterToUser userDtoConverterToUser;
    private UserConverterToDto userConverterToDto;
    private RoleConverterToDto roleConverterToDto;
    private RoleDtoConverterToRole roleDtoConverterToRole;

    @Autowired
    public void setUserDtoConverterToUser(UserDtoConverterToUser userDtoConverterToUser) {
        this.userDtoConverterToUser = userDtoConverterToUser;
    }

    @Autowired
    public void setUserConverterToDto(UserConverterToDto userConverterToDto) {
        this.userConverterToDto = userConverterToDto;
    }

    @Autowired
    public void setRoleDtoConverterToRole(RoleDtoConverterToRole roleDtoConverterToRole) {
        this.roleDtoConverterToRole = roleDtoConverterToRole;
    }

    @Autowired
    public void setRoleConverterToDto(RoleConverterToDto roleConverterToDto) {
        this.roleConverterToDto = roleConverterToDto;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new MovieConverter());
        registry.addConverter(userConverterToDto);
        registry.addConverter(userDtoConverterToUser);
        registry.addConverter(roleDtoConverterToRole);
        registry.addConverter(roleConverterToDto);
    }
}
