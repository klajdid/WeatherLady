package data;

import lombok.*;

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

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", referencedColumnName = "id_country")
    private CountryEntity country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_id", referencedColumnName = "id")
    private CurrentMeasurementEntity current;

}
