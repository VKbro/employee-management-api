package org.vijaykumark.employeemanagementapi.service;

import org.vijaykumark.employeemanagementapi.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeInformationServiceInterface {

    List<EmployeeDTO> getAllEmployeeData(int start, int end);
    Optional<EmployeeDTO> getEmployeeBy(Long id);
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    Optional<EmployeeDTO> updateEmployee(Long id, EmployeeDTO employeeDTO);
    Optional<EmployeeDTO> deleteEmployee(Long id);
}
