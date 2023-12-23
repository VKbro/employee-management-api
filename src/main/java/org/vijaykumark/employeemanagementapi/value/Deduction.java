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
public class Deduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull(message = "Professional tax is mandatory!")
    Double professionalTax;

    @NotNull(message = "Tax deducted at source is mandatory!")
    Double taxDeductedAtSource;

    @NotNull(message = "Employee provident fund is mandatory!")
    Double employeeProvidentFund;
    @OneToOne
    Salary salary;
}
