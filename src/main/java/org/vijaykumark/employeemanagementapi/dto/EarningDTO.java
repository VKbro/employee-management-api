package org.vijaykumark.employeemanagementapi.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.vijaykumark.employeemanagementapi.value.Earning;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EarningDTO {

    @Digits(integer = 8, fraction = 2)
    @NotNull(message = "Base salary is mandatory!")
    @Min(value = 1000, message = "Minimum salary should be {value}")
    @Max(value = 10000000, message = "Maximum salary should be {value}")
    Double baseSalary;

    @Digits(integer = 8, fraction = 2)
    @NotNull(message = "Dearness allowance is mandatory!")
    @Min(value = 1000, message = "Minimum salary should be {value}")
    @Max(value = 10000000, message = "Maximum salary should be {value}")
    Double dearnessAllowance;

    @Digits(integer = 8, fraction = 2)
    @NotNull(message = "House rent allowance is mandatory!")
    @Min(value = 1000, message = "Minimum salary should be {value}")
    @Max(value = 10000000, message = "Maximum salary should be {value}")
    Double houseRentAllowance;

    @Digits(integer = 8, fraction = 2)
    @NotNull(message = "Medical allowance is mandatory!")
    @Min(value = 1000, message = "Minimum salary should be {value}")
    @Max(value = 10000000, message = "Maximum salary should be {value}")
    Double medicalAllowance;

    @Digits(integer = 8, fraction = 2)
    @Min(value = 1000, message = "Minimum salary should be {value}")
    @Max(value = 10000000, message = "Maximum salary should be {value}")
    Double specialAllowance;

    public static EarningDTO toDTO(Earning earning) {
        return EarningDTO
            .builder()
            .baseSalary(earning.getBaseSalary())
            .dearnessAllowance(earning.getDearnessAllowance())
            .houseRentAllowance(earning.getHouseRentAllowance())
            .medicalAllowance(earning.getMedicalAllowance())
            .specialAllowance(earning.getSpecialAllowance())
            .build();
    }

    public Earning toEntity() {
        return Earning
            .builder()
            .baseSalary(this.baseSalary)
            .dearnessAllowance(this.dearnessAllowance)
            .houseRentAllowance(this.getHouseRentAllowance())
            .medicalAllowance(this.medicalAllowance)
            .specialAllowance(this.specialAllowance)
            .build();
    }
}
