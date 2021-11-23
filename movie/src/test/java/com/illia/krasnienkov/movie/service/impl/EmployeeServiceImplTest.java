package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.model_dtos.EmployeeDto;
import com.illia.krasnienkov.movie.model.Employee;
import com.illia.krasnienkov.movie.service.EmployeeService;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;

@Disabled
class EmployeeServiceImplTest extends CommonServiceImplTest<EmployeeDto, Employee> {


    @Autowired
    public EmployeeServiceImplTest(EmployeeService employeeService) {
        super(employeeService);
    }

}