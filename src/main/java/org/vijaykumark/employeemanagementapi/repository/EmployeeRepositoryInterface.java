package org.vijaykumark.employeemanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vijaykumark.employeemanagementapi.entity.Employee;

public interface EmployeeRepositoryInterface extends JpaRepository<Employee, Long> {}
