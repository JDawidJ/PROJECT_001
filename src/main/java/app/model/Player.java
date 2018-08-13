package app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private Integer goals;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "position_id")
    private Position position;
    //private Long position_id;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name ="health_card_id")
    private HealthCard healthCard;
    //private Long helthCard_id;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "team_id")
    private Team team;
    //private Long team_id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "players")
    private Set<Card> cards = new HashSet<>();
}
