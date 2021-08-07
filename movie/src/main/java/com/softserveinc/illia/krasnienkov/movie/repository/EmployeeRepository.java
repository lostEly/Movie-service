package com.softserveinc.illia.krasnienkov.movie.repository;

import com.softserveinc.illia.krasnienkov.movie.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
