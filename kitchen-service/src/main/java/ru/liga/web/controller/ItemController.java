package ru.liga.web.controller;

import ru.liga.web.mapper.ItemMapper;
import domain.enitity.kitchenService.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.service.ItemService;
import web.dto.kitchen.ItemDto;


import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/restaurant-api")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @GetMapping("/v1.0/item")
    public ResponseEntity<ItemDto> getItemByItemId(@RequestParam("id") long itemId) {
        var item = itemService.getItemByItemId(itemId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(itemMapper.toDto(item));
    }

    @GetMapping("/v1.0/items")
    public ResponseEntity<List<ItemDto>> getAllItemsByRestaurantId(@RequestParam("restaurantId") long restaurantId) {
        List<Item> items = itemService.getAllItemsByRestaurantId(restaurantId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(itemMapper.toDto(items));
    }

    @PatchMapping("/v1.0/update-item")
    public ResponseEntity<ItemDto> updateItemPriceByItemId(
            @RequestParam("id") long itemId,
            @RequestParam("price") BigDecimal itemPrice) {
        var item = itemService.updateItemPriceByItemId(itemId, itemPrice);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(itemMapper.toDto(item));
    }

    @PostMapping("/v1.0/create-item")
    public ResponseEntity<ItemDto> createItemByRestaurantId(@RequestParam("restaurantId") long restaurantId, ItemDto itemDto) {
        var item = itemMapper.toEntity(itemDto);
        item = itemService.createItemByRestaurantId(restaurantId, item);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(itemMapper.toDto(item));
    }

    @DeleteMapping("/v1.0/delete-item")
    public ResponseEntity<ItemDto> deleteItemByItemId(@RequestParam("id") long itemId) {
        var item = itemService.deleteItemByItemId(itemId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(itemMapper.toDto(item));
    }
}
