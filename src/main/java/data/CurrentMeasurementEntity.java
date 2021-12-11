package data;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "current_measurement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentMeasurementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer currentId;

    @Column(name = "observation_time")
    private String observationTime;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "wind_speed")
    private double windSpeed;

    @Column(name = "pressure")
    private double pressure;

    @OneToOne(mappedBy = "current")
    private LocationEntity user;


}
