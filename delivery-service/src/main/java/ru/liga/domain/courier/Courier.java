package ru.liga.domain.courier;

import lombok.*;
import ru.liga.domain.coordinate.Coordinate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "couriers")
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

}
