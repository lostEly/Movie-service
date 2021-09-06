package com.illia.krasnienkov.movie.service.impl;

import com.illia.krasnienkov.movie.dto.model_dtos.EmployeeDto;
import com.illia.krasnienkov.movie.exceptions.ResourceNotFoundException;
import com.illia.krasnienkov.movie.model.Employee;
import com.illia.krasnienkov.movie.model.User;
import com.illia.krasnienkov.movie.repository.EmployeeRepository;
import com.illia.krasnienkov.movie.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeServiceImpl.class);
    private EmployeeRepository employeeRepository;
    private ConversionService service;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    public void setService(ConversionService service) {
        this.service = service;
    }

    @Override
    public EmployeeDto create(Employee employee) {
        LOGGER.info("Started creating employee");
        Employee createdEmployee = employeeRepository.save(employee);
        EmployeeDto newEmployeeDto = service.convert(createdEmployee, EmployeeDto.class);
        LOGGER.info("Created employee");
        return newEmployeeDto;
    }

    @Override
    public List<EmployeeDto> readAll() {
        LOGGER.info("Started reading all employees");
        List<Employee> employees = employeeRepository.findAll();
        LOGGER.info("Read all employees");
        return employees.stream()
                .map(employee -> service.convert(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto readById(String id) {
        LOGGER.info("Started reading employee with id " + id);
        Employee employee = findEmployeeById(id);
        return service.convert(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto update(Employee employee) {
        LOGGER.warn("Started updating employee with id + " + employee.getId());
        if (employee.getId() == null)
            throw new RuntimeException("UserId == null");
        Employee updatedEmployee = employeeRepository.save(employee);
        LOGGER.info("Employee with id + " + updatedEmployee.getId() + " is updated");
        return service.convert(updatedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto patch(Map<String, Object> fields, String id) {
        LOGGER.warn("Started patching employee with id + " + id);
        Employee employee = findEmployeeById(id);
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(User.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, employee, v);
        });
        Employee patchedEmployee = employeeRepository.save(employee);
        LOGGER.info("Employee with id + " + employee.getId() + " is patched");
        return service.convert(patchedEmployee, EmployeeDto.class);
    }

    @Override
    public void deleteById(String id) {
        LOGGER.warn("Started deleting employee with id " + id);
        Employee employee = findEmployeeById(id);
        employeeRepository.delete(employee);
        LOGGER.info("Finished deleting employee with id " + id);
    }

    private Employee findEmployeeById(String id) {
        LOGGER.info("Started reading employee by id");
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            LOGGER.error("employee with id + " + id + " not found");
            throw new ResourceNotFoundException("employee with id " + id);
        }
        Employee employee = optionalEmployee.get();
        LOGGER.info("Finished reading user by id");
        return employee;
    }
}
