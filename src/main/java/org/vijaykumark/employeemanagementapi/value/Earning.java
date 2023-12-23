package org.vijaykumark.employeemanagementapi.value;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Earning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull(message = "Base Salary is mandatory!")
    Double baseSalary;

    @NotNull(message = "Dearness allowance is mandatory!")
    Double dearnessAllowance;

    @NotNull(message = "House rent allowance is mandatory!")
    Double houseRentAllowance;

    @NotNull(message = "Medical allowance is mandatory!")
    Double medicalAllowance;
    Double specialAllowance;
    @OneToOne
    Salary salary;
}
