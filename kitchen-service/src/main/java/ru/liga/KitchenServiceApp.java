package ru.liga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.liga.config.CommonConfig;

@SpringBootApplication
@EnableTransactionManagement
@Import(value = {CommonConfig.class})
public class KitchenServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(KitchenServiceApp.class, args);
    }

}
