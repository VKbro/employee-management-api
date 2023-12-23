package org.vijaykumark.employeemanagementapi.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.vijaykumark.employeemanagementapi.entity.Employee;
import org.vijaykumark.employeemanagementapi.value.Salary;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotEmpty(message = "Name is mandatory!")
    @Size(min = 4)
    private String name;

    private SalaryDTO salary;

    @NotEmpty(message = "Department is mandatory")
    @Size(min = 4)
    private String department;

    public static EmployeeDTO toDTO(Employee employee) {
        return EmployeeDTO
            .builder()
            .name(employee.getName())
            .salary(SalaryDTO.toDTO(employee.getSalary()))
            .department(employee.getDepartment())
            .build();
    }

    public Employee toEntity() {
        return Employee
            .builder()
            .name(this.name)
            .Salary(this.salary.toEntity())
            .department(this.department)
            .build();
    }
}
