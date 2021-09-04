package com.illia.krasnienkov.fake.data.service.generator;

import com.illia.krasnienkov.fake.data.service.modelDtos.Employee;

public class EmployeeGenerator extends DataGenerator<Employee> {

    @Override
    public Employee initializeFields() {
        Employee employee = new Employee();
        employee.setName(faker.name().firstName());
        employee.setLastName(faker.name().lastName().replaceAll("'", "''"));
        return employee;
    }
}
