package app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private String capitol;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "country")
    private Set<Player> players;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "country")
    private Set<Team>teams=new HashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "country")
    private Set<Manager>managers=new HashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "country")
    private Set<Company>companies=new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) &&
                Objects.equals(name, country.name) &&
                Objects.equals(capitol, country.capitol);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, capitol);
    }
}
