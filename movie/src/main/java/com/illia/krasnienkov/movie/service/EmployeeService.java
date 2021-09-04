package com.illia.krasnienkov.movie.service;

import com.illia.krasnienkov.movie.dto.EmployeeDto;
import com.illia.krasnienkov.movie.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    EmployeeDto create(Employee employee);

    List<EmployeeDto> readAll();

    EmployeeDto readById(String id);

    EmployeeDto update(Employee employee);

    EmployeeDto patch(Map<String, Object> fields, String id);

    void deleteById(String id);
}
