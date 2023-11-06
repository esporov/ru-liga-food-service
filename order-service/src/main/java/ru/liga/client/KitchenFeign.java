package ru.liga.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.liga.domain.enitity.kitchenService.item.Item;

@Component
@FeignClient(name = "kitchen-service", url = "http://localhost:8081/restaurant-api")
public interface KitchenFeign {

    @GetMapping("/v1.0/itemFeign/id/{id}")
    Item getItemByItemId(@PathVariable("id") long id);
}
