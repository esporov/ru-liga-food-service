package ru.liga.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingMQConfig {
    @Bean
    public Declarables myBaseQueue() {
        Queue queueDirectFirst = new Queue("kitchen", false, false, false);
        Queue queueDirectSecond = new Queue("delivery", false);
        DirectExchange directExchange = new DirectExchange("KitchenDeliveryExchange");
        return new Declarables(queueDirectFirst, queueDirectSecond, directExchange,
                BindingBuilder
                        .bind(queueDirectFirst)
                        .to(directExchange)
                        .with("kitchen"),
                BindingBuilder.bind(queueDirectSecond)
                        .to(directExchange)
                        .with("delivery"));
    }

    @Bean
    Declarables kitchenQueue() {
        Queue queueDirectFirst = new Queue("Мак", false);
        Queue queueDirectSecond = new Queue("БугерКвин", false);
        Queue queueDirectThird = new Queue("КФЦ", false);
        DirectExchange directExchange = new DirectExchange("RestaurantNameExchange");
        return new Declarables(queueDirectFirst, queueDirectSecond, queueDirectThird ,directExchange,
                BindingBuilder
                        .bind(queueDirectFirst)
                        .to(directExchange)
                        .with("Мак"),
                BindingBuilder.bind(queueDirectSecond)
                        .to(directExchange)
                        .with("БугерКвин"),
                BindingBuilder.bind(queueDirectThird)
                        .to(directExchange)
                        .with("КФЦ")
                );
    }
}
