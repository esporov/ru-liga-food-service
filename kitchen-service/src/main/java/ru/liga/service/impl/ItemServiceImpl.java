package ru.liga.service.impl;

import domain.enitity.kitchenService.item.Item;
import domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.repository.ItemRepository;
import ru.liga.repository.RestaurantRepository;
import ru.liga.service.ItemService;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Item getItemByItemId(long id) {
        try {
            return itemRepository.getItemByItemId(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Позиции с id = " + id + " не существует."));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Item> getAllItemsByRestaurantId(long id) {
        try {
            List<Item> items = itemRepository.getAllItemsByRestaurantId(id);
            if (items.size() == 0) {
                throw new ResourceNotFoundException("Ресторана с id = " + id + " не существует.");
            }
            return items;
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public Item updateItemPriceByItemId(long itemId, BigDecimal price) {
        Item item = getItemByItemId(itemId);
        item.setItemPrice(price);
        return itemRepository.save(item);
    }

    @Transactional
    @Override
    public Item createItemByRestaurantId(long restaurantId, Item item) {
        try {
            item.setRestaurant(restaurantRepository.getRestaurantByRestaurantId(restaurantId)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Ресторана с id = " + restaurantId + " не существует.")));
            item.setItemImage("https://images.restaurant/?id=" + restaurantId + "&item-id=???");
            item.setItemDescription(item.getItemName());
            itemRepository.save(item);
            return item;
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public Item deleteItemByItemId(long itemId) {
        var item = getItemByItemId(itemId);
        itemRepository.deleteById(itemId);
        return item;
    }
}
