package app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue
    private Long id;
    private Integer expirationDate;
    private BigDecimal cost;


@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name = "team_id")
    private Team team;
@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name = "company_id")
    private Company company;

}
