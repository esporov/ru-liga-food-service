package ru.liga.domain.enitity.customerService.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name = "customer_addressees")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long addressId;

    private String city;

    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "house_section")
    private String houseSection;
    @Column(name = "house_floor")
    private String houseFloor;
    @Column(name = "apartment_number")
    private String apartmentNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "customer_id",referencedColumnName = "customer_id")
    private Customer customer;
}
