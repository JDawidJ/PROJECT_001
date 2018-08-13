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
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer position;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stadium")
    private Stadium stadium;
    //private Long stadium_id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "manager_id")
    private Manager manager;



    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "country_id")
    private Country country;


    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "team",fetch = FetchType.EAGER)
    private Set<Player>players=new HashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "team")
    private Set<Contract>contracts=new HashSet<>();
}
