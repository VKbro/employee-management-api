package org.vijaykumark.employeemanagementapi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.vijaykumark.employeemanagementapi.value.Salary;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDTO {
    private EarningDTO earning;
    private DeductionDTO deduction;

    public static SalaryDTO toDTO(Salary salary) {
        return SalaryDTO
            .builder()
            .earning(EarningDTO.toDTO(salary.getEarning()))
            .deduction(DeductionDTO.toDTO(salary.getDeduction()))
            .build();
    }

    public Salary toEntity() {
        return Salary
            .builder()
            .earning(this.earning.toEntity())
            .deduction(this.deduction.toEntity())
            .build();

    }
}
