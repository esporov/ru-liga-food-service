package domain.enitity.deliveryService.coordinate;


import domain.enitity.deliveryService.courier.Courier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Courier courier;

}
