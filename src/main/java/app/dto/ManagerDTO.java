package app.dto;

import app.model.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagerDTO {
    private Long id;
    private String name;
    private String surname;
    private  Integer age;
    private CountryDTO countryDTO;
}
