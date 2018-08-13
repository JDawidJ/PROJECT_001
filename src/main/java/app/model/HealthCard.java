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
@Table(name = "health_cards")
public class HealthCard {
    @Id
    @GeneratedValue
    private Long id;
    private Integer examDate;

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "healthCard")
    private Player player;
    @ElementCollection
    @CollectionTable(name = "injuries",
    joinColumns = @JoinColumn(name = "health_card_id")
    )
    @Column(name = "injury")
    @Enumerated(EnumType.STRING)

    private Set<Injury> injuries = new HashSet<>();
}
