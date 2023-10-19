package ru.liga.service;

import ru.liga.domain.item.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item getItemByItemId(long itemId);

    List<Item> getAllItemsByRestaurantId(long restaurantId);

    Item updateItemPriceByItemId(long itemId, BigDecimal itemPrice);

    Item createItemByRestaurantId(long restaurantId, Item item);

    Item deleteItemByItemId(long itemId);


}
