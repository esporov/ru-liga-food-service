package ru.liga;

import domain.enitity.deliveryService.coordinate.Coordinate;
import domain.enitity.deliveryService.courier.Courier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackageClasses = {Courier.class, Coordinate.class})
public class DeliveryServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryServiceApp.class, args);
    }
}
