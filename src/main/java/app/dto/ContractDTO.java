package app.dto;

import app.model.Company;
import app.model.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractDTO {
    private Long id;
    private Integer expirationDate;
    private BigDecimal cost;
    private Team team;
    private CompanyDTO companyDTO;
}
