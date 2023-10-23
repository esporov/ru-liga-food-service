package ru.liga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CustomerServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApp.class, args);
    }
}
