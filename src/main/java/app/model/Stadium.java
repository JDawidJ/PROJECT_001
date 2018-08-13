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
@Table(name = "stadiums")
public class Stadium {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer capacity;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "stadium")
    private Set<Team>teams=new HashSet<>();
}
