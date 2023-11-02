package ru.liga.domain.enitity.deliveryService.courier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "couriers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courier_id")
    private long courierId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "courier_status")
    private CourierStatus courierStatus;

    @Override
    public String toString() {
        return "Courier{" +
                "courierId=" + courierId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", courierStatus=" + courierStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Courier courier = (Courier) o;

        if (courierId != courier.courierId) return false;
        if (!Objects.equals(phoneNumber, courier.phoneNumber)) return false;
        return courierStatus == courier.courierStatus;
    }

    @Override
    public int hashCode() {
        int result = (int) (courierId ^ (courierId >>> 32));
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (courierStatus != null ? courierStatus.hashCode() : 0);
        return result;
    }
}
