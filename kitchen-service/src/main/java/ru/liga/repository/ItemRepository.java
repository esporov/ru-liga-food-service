package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.liga.domain.enitity.kitchenService.item.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> getItemByItemIdAndRestaurantRestaurantId(long itemId, long restaurantId);

    @Query("select i " +
            "from Item i " +
            "where i.restaurant.restaurantId = :id")
    List<Item> getAllItemsByRestaurantId(@Param("id") long restaurantId);

    @Modifying
    @Query("update Item i " +
            "set i.itemPrice = :price " +
            "where i.itemId = :id")
    void updateItemPriceByItemId(@Param("id") long itemId, @Param("price") BigDecimal itemPrice);

}
