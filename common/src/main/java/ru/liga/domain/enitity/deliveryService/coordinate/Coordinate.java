package ru.liga.domain.enitity.deliveryService.coordinate;


import lombok.*;
import ru.liga.domain.enitity.deliveryService.courier.Courier;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "coordinates")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Coordinate {

    @Id
    @Column(name = "courier_id")
    private long courierId;

    private float latitude;

    private float longitude;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @MapsId
    private Courier courier;

    @Override
    public String toString() {
        return "Coordinate{" +
                "courierId=" + courierId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", courier=" + courier +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (courierId != that.courierId) return false;
        if (Float.compare(that.latitude, latitude) != 0) return false;
        if (Float.compare(that.longitude, longitude) != 0) return false;
        return Objects.equals(courier, that.courier);
    }

    @Override
    public int hashCode() {
        int result = (int) (courierId ^ (courierId >>> 32));
        result = 31 * result + (latitude != +0.0f ? Float.floatToIntBits(latitude) : 0);
        result = 31 * result + (longitude != +0.0f ? Float.floatToIntBits(longitude) : 0);
        result = 31 * result + (courier != null ? courier.hashCode() : 0);
        return result;
    }
}
