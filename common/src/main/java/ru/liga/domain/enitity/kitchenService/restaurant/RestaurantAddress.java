package ru.liga.domain.enitity.kitchenService.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn (name = "restaurant_id",referencedColumnName = "restaurant_id")
    private Restaurant restaurant;

}
