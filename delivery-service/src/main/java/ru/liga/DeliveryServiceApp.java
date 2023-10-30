package ru.liga;

import org.springframework.context.annotation.Import;
import ru.liga.config.CommonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@Import(value = {CommonConfig.class})
public class DeliveryServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryServiceApp.class, args);
    }
}
