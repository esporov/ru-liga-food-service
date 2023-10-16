package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.liga.domain.restaurant.Restaurant;
import ru.liga.domain.restaurant.RestaurantAddress;
import ru.liga.domain.restaurant.RestaurantStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> getRestaurantByRestaurantId(long restaurantId);

    @Query(value = "select ra from RestaurantAddress ra where ra.restaurant.restaurantId = :id")
    List<RestaurantAddress> getAllRestaurantsByRestaurantId(@Param("id") long id);

    @Query(value = "SELECT * FROM restaurants " +
            "LEFT JOIN restaurants_restaurant_address USING (restaurant_id) " +
            "LEFT JOIN restaurant_address USING (address_id) " +
            "WHERE restaurant_name = :restaurantName", nativeQuery = true)
    List<Restaurant> findAllByRestaurantName(@Param("restaurantName") String restaurantName);

    @Modifying
    @Query(value = "update RestaurantAddress ra  set ra.restaurantStatus = :restaurantStatus where ra.addressId = :addressId")
    void updateRestaurantStatusByAddressId(@Param("addressId") long addressId,
                                           @Param("restaurantStatus") String restaurantStatus);

    @Query(value =
            "select ra " +
                    "from RestaurantAddress ra " +
                    /*"left join fetch ra.restaurant r  " +*/
                    "where ra.restaurantStatus = :restaurantStatus")
    List<RestaurantAddress> getRestaurantByRestaurantStatus(@Param("restaurantStatus") RestaurantStatus restaurantStatus);


    void updateByRestaurantName(String restaurantName, String newRestaurantName);



    /*@Query(value = "UPDATE restaurant_address " +
            "SET restaurant_status = :restaurantStatus " +
            "WHERE  address_id = :addressId", nativeQuery = true)
    void updateRestaurantStatusByAddressId(@Param("addressId") long addressId,
                                           @Param("restaurantStatus") String restaurantStatus);*/

}
