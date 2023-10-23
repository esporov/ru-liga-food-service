package ru.liga.repository;

import domain.enitity.kitchenService.item.Item;
import domain.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("select i " +
            "from Item i " +
            "where i.itemId = :id")
    Optional<Item> getItemByItemId(@Param("id") long itemId) throws ResourceNotFoundException;

    @Query("select i " +
            "from Item i " +
            "where i.restaurant.restaurantId = :id")
    List<Item> getAllItemsByRestaurantId(@Param("id") long restaurantId) throws ResourceNotFoundException;

    @Modifying
    @Query("update Item i " +
            "set i.itemPrice = :price " +
            "where i.itemId = :id")
    void updateItemPriceByItemId(@Param("id") long itemId, @Param("price") BigDecimal itemPrice);
}
