package org.vijaykumark.employeemanagementapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vijaykumark.employeemanagementapi.dto.EmployeeDTO;
import org.vijaykumark.employeemanagementapi.service.EmployeeInformationService;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing employees.
 * It handles HTTP requests and responses.
 */
@RestController
@RequestMapping({"employees", "employees/"})
@RequiredArgsConstructor
public class EmployeeController {

    // Service for managing employee information
    private final EmployeeInformationService employeeService;

    /**
     * Get all employees with pagination.
     * @param start The starting index of the employees list.
     * @param end The ending index of the employees list.
     * @return A list of employees.
     */
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(
        @RequestParam(defaultValue = "0") int start,
        @RequestParam(defaultValue = "10") int end
    ) {
        return ResponseEntity.ok(employeeService.getAllEmployeeData(start, end));
    }

    /**
     * Get an employee by ID.
     * @param id The ID of the employee.
     * @return The employee if found, otherwise returns HTTP status NOT_FOUND.
     */
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeBy(
        @Valid @PathVariable Long id
    ) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeBy(id);
        return employeeDTO
            .map(ResponseEntity::ok)
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Add a new employee.
     * @param employeeDTO The employee data transfer object.
     * @return The added employee.
     */
    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(
        @Valid @RequestBody EmployeeDTO employeeDTO
    ) {
        return ResponseEntity.ok(employeeService.addEmployee(employeeDTO));
    }

    /**
     * Update an employee by ID.
     * @param id The ID of the employee.
     * @param employeeDTO The employee data transfer object.
     * @return The updated employee if found, otherwise returns HTTP status NOT_FOUND.
     */
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployeeBy(
        @Valid @PathVariable Long id,
        @Valid @RequestBody EmployeeDTO employeeDTO
    ) {
        Optional<EmployeeDTO> optionalEmployeeDTO = employeeService.updateEmployee(id, employeeDTO);

        return optionalEmployeeDTO
            .map(ResponseEntity::ok)
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete an employee by ID.
     * @param id The ID of the employee.
     * @return The deleted employee if found, otherwise returns HTTP status NOT_FOUND.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<EmployeeDTO> deleteEmployeeBy(
        @Valid @PathVariable Long id
    ) {
        Optional<EmployeeDTO> employee = employeeService.deleteEmployee(id);

        return employee
            .map(ResponseEntity::ok)
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
