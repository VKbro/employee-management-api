package org.vijaykumark.employeemanagementapi.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.vijaykumark.employeemanagementapi.value.Deduction;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeductionDTO {

    @Digits(integer = 8, fraction = 2)
    @NotNull(message = "Professional tax fund is mandatory!")
    @Min(value = 1000, message = "Minimum salary should be {value}")
    @Max(value = 10000000, message = "Maximum salary should be {value}")
    Double professionalTax;

    @Digits(integer = 8, fraction = 2)
    @NotNull(message = "Tax deducted at source is mandatory!")
    @Min(value = 1000, message = "Minimum salary should be {value}")
    @Max(value = 10000000, message = "Maximum salary should be {value}")
    Double taxDeductedAtSource;

    @Digits(integer = 8, fraction = 2)
    @NotNull(message = "Employee provident fund is mandatory!")
    @Min(value = 1000, message = "Minimum salary should be {value}")
    @Max(value = 10000000, message = "Maximum salary should be {value}")
    Double employeeProvidentFund;

    public static DeductionDTO toDTO(Deduction deduction) {
        return DeductionDTO
            .builder()
            .professionalTax(deduction.getProfessionalTax())
            .taxDeductedAtSource(deduction.getTaxDeductedAtSource())
            .employeeProvidentFund(deduction.getEmployeeProvidentFund())
            .build();
    }

    public Deduction toEntity() {
        return Deduction
            .builder()
            .professionalTax(this.professionalTax)
            .taxDeductedAtSource(this.taxDeductedAtSource)
            .employeeProvidentFund(this.employeeProvidentFund)
            .build();
    }
}
