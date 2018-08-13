package app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cards")

public class Card {
    @Id
    @GeneratedValue
    private Long id;
    private String colour;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "player_card",
            joinColumns = @JoinColumn (name = "card_id"),
            inverseJoinColumns = @JoinColumn(name ="player_id" )
    )
    private Set<Player>players=new HashSet<>();
}
