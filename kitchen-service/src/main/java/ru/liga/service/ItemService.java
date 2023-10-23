package ru.liga.service;

import ru.liga.domain.item.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Optional<Item> getItemByRestaurantIdAndItemId(long restaurantId, long itemId);

    List<Item> getAllItemsByRestaurantName(String name);

    List<Item> getAllAvailableItemsByRestaurantName(String name);

    void updateItemPriceByRestaurantNameAndItemName(String restaurantName, String itemName, int price);

    void updateItemByRestaurantNameAndItemName(String restaurantName, String itemName, Item item);

    void updateItemStatusByRestaurantIdAndItemId(long restaurantId, long itemId);

    void createItemByRestaurantName(String restaurantName, Item item);

    void createItemByRestaurantId(long restaurantId, Item item);
}
