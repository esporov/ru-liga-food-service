package ru.liga;

import domain.enitity.customerService.customer.Customer;
import domain.enitity.customerService.customer.CustomerAddress;
import domain.enitity.deliveryService.coordinate.Coordinate;
import domain.enitity.deliveryService.courier.Courier;
import domain.enitity.kitchenService.item.Item;
import domain.enitity.kitchenService.restaurant.Restaurant;
import domain.enitity.kitchenService.restaurant.RestaurantAddress;
import domain.enitity.orderService.order.Order;
import domain.enitity.orderService.orderItem.OrderItem;
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
