package ru.liga.domain.enitity.deliveryService.coordinate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.liga.domain.enitity.deliveryService.courier.Courier;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coordinates")
public class Coordinate {

    @Id
    @Column(name = "courier_id")
    private long courierId;

    private float latitude;

    private float longitude;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @MapsId
    private Courier courier;

}
