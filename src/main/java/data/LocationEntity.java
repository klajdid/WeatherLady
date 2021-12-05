package data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "location")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "temprature")
    private double temprature;

    @OneToMany(mappedBy = "location", cascade = {CascadeType.ALL})
    private Set<CountryEntity> countries;

}
