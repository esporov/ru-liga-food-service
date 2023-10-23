package ru.liga;

import domain.enitity.kitchenService.item.Item;
import domain.enitity.kitchenService.restaurant.Restaurant;
import domain.enitity.kitchenService.restaurant.RestaurantAddress;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackageClasses = {Item.class, Restaurant.class, RestaurantAddress.class})
public class KitchenServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(KitchenServiceApp.class, args);
    }

}
