package org.vijaykumark.employeemanagementapi.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.vijaykumark.employeemanagementapi.dto.EmployeeDTO;
import org.vijaykumark.employeemanagementapi.entity.Employee;
import org.vijaykumark.employeemanagementapi.repository.EmployeeRepositoryInterface;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing employee information.
 * It implements the EmployeeInformationServiceInterface.
 */
@Data
@Service
@RequiredArgsConstructor
public class EmployeeInformationService implements EmployeeInformationServiceInterface {

    // Repository for managing employee data
    private final EmployeeRepositoryInterface employeeRepository;

    /**
     * Get all employee data with pagination.
     * @param start The starting index of the employees list.
     * @param end The ending index of the employees list.
     * @return A list of employee data transfer objects.
     */
    public List<EmployeeDTO> getAllEmployeeData (int start, int end) {
        Pageable pageable = PageRequest.of(start, end);
        return employeeRepository.findAll(pageable).stream().map(EmployeeDTO::toDTO).toList();
    }

    /**
     * Get an employee by ID.
     * @param id The ID of the employee.
     * @return The employee data transfer object if found.
     */
    public Optional<EmployeeDTO> getEmployeeBy(Long id) {
        return employeeRepository.findById(id).map(EmployeeDTO::toDTO);
    }

    /**
     * Add a new employee.
     * @param employeeDTO The employee data transfer object.
     * @return The added employee data transfer object.
     */
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.save(employeeDTO.toEntity());
        return employeeDTO;
    }

    /**
     * Update an employee by ID.
     * @param id The ID of the employee.
     * @param employeeDTO The employee data transfer object.
     * @return The updated employee data transfer object if found.
     */
    public Optional<EmployeeDTO> updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employee.get().setName(employeeDTO.getName());
            employee.get().setSalary(employeeDTO.getSalary().toEntity());
            employee.get().setDepartment(employeeDTO.getDepartment());
            employeeRepository.save(employee.get());
        }
        return employee.stream().map(EmployeeDTO::toDTO).findFirst();
    }

    /**
     * Delete an employee by ID.
     * @param id The ID of the employee.
     * @return The deleted employee data transfer object if found.
     */
    public Optional<EmployeeDTO> deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isEmpty()) return employee.map(EmployeeDTO::toDTO);
        employeeRepository.deleteById(id);
        return employee.map(EmployeeDTO::toDTO);
    }
}
