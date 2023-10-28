package ru.liga.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.domain.enitity.kitchenService.item.Item;
import ru.liga.service.ItemService;
import ru.liga.web.dto.kitchen.ItemDto;
import ru.liga.web.mapper.kitchen.ItemMapper;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/restaurant-api")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @GetMapping("/v1.0/item/id/{id}")
    public ResponseEntity<ItemDto> getItemByItemId(@PathVariable("id") long itemId) {
        var item = itemService.getItemByItemId(itemId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(itemMapper.toDto(item));
    }

    @GetMapping("/v1.0/itemFeign/id/{id}")
    public ResponseEntity<Item> getItemByItemIdForFeign(@PathVariable("id") long itemId) {
        var item = itemService.getItemByItemId(itemId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(item);
    }

    @GetMapping("/v1.0/restaurant/id/{id}/items")
    public ResponseEntity<List<ItemDto>> getAllItemsByRestaurantId(@PathVariable("id") long restaurantId) {
        List<Item> items = itemService.getAllItemsByRestaurantId(restaurantId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(itemMapper.toDto(items));
    }

    @PatchMapping("/v1.0/item/id/{id}/updatePrice/{price}")
    public ResponseEntity<ItemDto> updateItemPriceByItemId(
            @PathVariable("id") long itemId,
            @PathVariable("price") BigDecimal itemPrice) {
        var item = itemService.updateItemPriceByItemId(itemId, itemPrice);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(itemMapper.toDto(item));
    }

    @PostMapping("/v1.0/restaurant/id/{id}/item/create")
    public ResponseEntity<ItemDto> createItemByRestaurantId(@PathVariable("id") long restaurantId,
                                                            @RequestBody ItemDto itemDto) {
        var item = itemMapper.toEntity(itemDto);
        item = itemService.createItemByRestaurantId(restaurantId, item);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(itemMapper.toDto(item));
    }

    @DeleteMapping("/v1.0/item/id/{id}/delete")
    public ResponseEntity<ItemDto> deleteItemByItemId(@PathVariable("id") long itemId) {
        var item = itemService.deleteItemByItemId(itemId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(itemMapper.toDto(item));
    }
}
