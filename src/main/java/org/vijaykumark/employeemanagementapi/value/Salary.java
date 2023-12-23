package org.vijaykumark.employeemanagementapi.value;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.vijaykumark.employeemanagementapi.entity.Employee;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(cascade = CascadeType.ALL)
    Earning earning;

    @OneToOne(cascade = CascadeType.ALL)
    Deduction deduction;

    @OneToOne
    Employee employee;
}
