package app.dto;

import app.model.Country;
import app.model.HealthCard;
import app.model.Position;
import app.model.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDTO {
    private Long id;
    private String name;
    private String surname;
    private Integer goals;
    private PositionDTO positionDTO;
    private HealthCardDTO healthCardDTO;
    private CountryDTO countryDTO;
    private TeamDTO teamDTO;
  //  private CompanyDTO companyDTO;
}
