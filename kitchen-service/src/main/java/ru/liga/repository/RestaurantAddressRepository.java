package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantAddress;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantStatus;

import java.util.List;

@Repository
public interface RestaurantAddressRepository extends JpaRepository<RestaurantAddress, Long> {
    @Query("select ra " +
            "from RestaurantAddress ra " +
            "where ra.restaurant.restaurantId = :id")
    List<RestaurantAddress> getAllRestaurantAddressesByRestaurantId(@Param("id") long id);

    @Query("select ra " +
            "from RestaurantAddress ra " +
            "where ra.restaurant.restaurantName = :name")
    List<RestaurantAddress> getAllRestaurantAddressesByRestaurantName(@Param("name") String name);

    @Query("select ra " +
            "from RestaurantAddress ra " +
//            "join fetch RestaurantAddress.restaurant "+
            "where ra.restaurant.restaurantId = :id and ra.restaurantStatus = :status " +
            "order by ra.addressId")
    List<RestaurantAddress> getAllRestaurantAddressByRestaurantIdAndRestaurantStatus(
            @Param("id") long addressId,
            @Param("status") RestaurantStatus restaurantStatus);

    @Modifying
    @Query("update RestaurantAddress ra  " +
            "set ra.restaurantStatus = :restaurantStatus " +
            "where ra.addressId = :id")
    void updateRestaurantAddressStatusByAddressId(
            @Param("id") long id,
            @Param("restaurantStatus") RestaurantStatus restaurantStatus);


}
