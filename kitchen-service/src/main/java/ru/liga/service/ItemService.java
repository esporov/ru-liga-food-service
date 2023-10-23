package ru.liga.service;


import domain.enitity.kitchenService.item.Item;

import java.math.BigDecimal;
import java.util.List;

public interface ItemService {

    Item getItemByItemId(long itemId);

    List<Item> getAllItemsByRestaurantId(long restaurantId);

    Item updateItemPriceByItemId(long itemId, BigDecimal itemPrice);

    Item createItemByRestaurantId(long restaurantId, Item item);

    Item deleteItemByItemId(long itemId);


}
