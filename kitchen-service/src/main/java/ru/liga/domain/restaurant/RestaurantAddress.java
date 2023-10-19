package ru.liga.domain.restaurant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant_address")
public  class RestaurantAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long addressId;

    @Column(name = "street_name")
    private String streetName;

    private String city;

    @Column(name = "date_of_add")
    private Date dateOfAdd;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "work_status")
    private RestaurantStatus restaurantStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "restaurant_id",referencedColumnName = "restaurant_id")
    private Restaurant restaurant;

}
