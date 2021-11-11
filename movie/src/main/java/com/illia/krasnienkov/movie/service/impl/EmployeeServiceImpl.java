package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.model_dtos.EmployeeDto;
import com.illia.krasnienkov.movie.model.Employee;
import com.illia.krasnienkov.movie.repository.EmployeeRepository;
import com.illia.krasnienkov.movie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ModelsServiceImpl<EmployeeDto, Employee> implements EmployeeService {
    private EmployeeRepository employeeRepository;

    protected EmployeeServiceImpl(@Qualifier("employeeRepository") JpaRepository<Employee, String> repository, ConversionService service) {
        super(repository, service, EmployeeDto.class, Employee.class);
    }
}
