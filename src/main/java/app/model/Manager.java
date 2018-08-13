package app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private  Integer age;

@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name = "manager")
    private Country country;

@OneToOne(cascade = CascadeType.PERSIST,mappedBy = "manager")
private Team team;
}
