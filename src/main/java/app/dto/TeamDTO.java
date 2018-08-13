package app.dto;

import app.model.Country;
import app.model.Manager;
import app.model.Stadium;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamDTO {
    private Long id;
    private String name;
    private Integer position;
    private StadiumDTO stadiumDTO;
    private ManagerDTO managerDTO;
    private CountryDTO countryDTO;
}
