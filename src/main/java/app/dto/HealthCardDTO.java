package app.dto;

import app.model.Injury;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HealthCardDTO {
    private Long id;
    private Integer examDate;
    private Set<Injury> injuries = new HashSet<>();
    private PlayerDTO playerDTO;
}
