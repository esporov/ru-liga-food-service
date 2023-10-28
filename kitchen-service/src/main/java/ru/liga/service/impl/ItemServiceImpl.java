package ru.liga.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.domain.enitity.kitchenService.item.Item;
import ru.liga.domain.exception.ItemNotFoundException;
import ru.liga.repository.ItemRepository;
import ru.liga.service.ItemService;
import ru.liga.service.RestaurantService;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final RestaurantService restaurantService;

    @Override
    public Item getItemByItemId(long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Позиции с id = " + id + " не существует."));
    }

    @Override
    public List<Item> getAllItemsByRestaurantId(long id) {
        restaurantService.getRestaurantByRestaurantId(id);
        List<Item> items = itemRepository.getAllItemsByRestaurantId(id);
        if (items.size() == 0) {
            throw new ItemNotFoundException("Меню для ресторана с id = " + id + " не существует.");
        }
        return items;
    }

    @Transactional
    @Override
    public Item updateItemPriceByItemId(long itemId, BigDecimal price) {
        Item item = getItemByItemId(itemId);
        itemRepository.updateItemPriceByItemId(itemId, price);
        item.setItemPrice(price);
        return item;
    }

    @Transactional
    @Override
    public Item createItemByRestaurantId(long restaurantId, Item item) {
        var restaurant = restaurantService.getRestaurantByRestaurantId(restaurantId);
        item.setRestaurant(restaurant);
        item.setItemImage("https://images.restaurant/?id=" + restaurantId + "&item-id=???");
        item.setItemDescription(item.getItemName());
        return itemRepository.save(item);
    }

    @Transactional
    @Override
    public Item deleteItemByItemId(long itemId) {
        var item = getItemByItemId(itemId);
        itemRepository.deleteById(itemId);
        return item;
    }
}
