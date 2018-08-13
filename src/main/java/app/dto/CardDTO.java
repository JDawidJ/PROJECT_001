package app.dto;

import app.model.Player;
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
public class CardDTO {
    private Long id;
    private String colour;
    private Set<Player>players=new HashSet<>();
}
