package data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "region")
    private String region;

    @Column (name = "country_name")
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "id")
    private  LocationEntity location;


}
