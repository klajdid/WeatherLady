package data;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_country")
    private Integer id;

    @Column(name = "region")
    private String region;

    @Column (name = "country_name")
    private String countryName;

    @OneToOne(mappedBy = "country")
    private LocationEntity user;

}
