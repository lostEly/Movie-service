package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.model_dtos.EmployeeDto;
import com.illia.krasnienkov.movie.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService extends ModelsService<EmployeeDto, Employee> {
    @Override
    EmployeeDto create(Employee employee);

    @Override
    List<EmployeeDto> readAll();

    @Override
    EmployeeDto readById(String id);

    @Override
    EmployeeDto update(Employee employee);

    @Override
    EmployeeDto patch(Map<String, Object> fields, String id);

    @Override
    void deleteById(String id);
}
