package ru.liga;

import ru.liga.domain.enitity.customerService.customer.Customer;
import ru.liga.domain.enitity.customerService.customer.CustomerAddress;
import ru.liga.domain.enitity.deliveryService.coordinate.Coordinate;
import ru.liga.domain.enitity.deliveryService.courier.Courier;
import ru.liga.domain.enitity.kitchenService.item.Item;
import ru.liga.domain.enitity.kitchenService.restaurant.Restaurant;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantAddress;
import ru.liga.domain.enitity.orderService.order.Order;
import ru.liga.domain.enitity.orderService.orderItem.OrderItem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackageClasses = {
        Item.class, Restaurant.class, RestaurantAddress.class, Customer.class, CustomerAddress.class,
        Courier.class, Coordinate.class, Order.class, OrderItem.class})
public class OrderServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApp.class, args);
    }
}
