package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.liga.domain.restaurant.Restaurant;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByRestaurantName(String restaurantName);

    @Query(value = "SELECT * " +
            "FROM restaurants " +
            "WHERE restaurant_id = :id", nativeQuery = true)
    Optional<Restaurant> getRestaurantById(@Param("id") long id);

    @Query(value = "SELECT * FROM restaurants " +
            "LEFT JOIN restaurants_restaurant_address USING (restaurant_id) " +
            "LEFT JOIN restaurant_address USING (address_id) " +
            "WHERE restaurant_name = :restaurantName", nativeQuery = true)
    List<Restaurant> findAllByRestaurantName(@Param("restaurantName") String restaurantName);

    @Query(value = "UPDATE restaurants " +
            "SET restaurant_name = : newRestaurantname " +
            "WHERE restaurant_name = : restaurantname", nativeQuery = true)
    void updateRestaurantName(@Param("restaurantName") String restaurantName,
                              @Param("newRestaurantName") String newRestaurantName);


    @Query(value = "UPDATE restaurant_address " +
            "SET restaurant_status = :restaurantStatus " +
            "WHERE  address_id IN " +
            "(SELECT address_id " +
            "FROM restaurants " +
            "LEFT JOIN restaurants_restaurant_address USING (restaurant_id) " +
            "LEFT JOIN restaurant_address USING (address_id) " +
            "WHERE restaurant_name = :restaurantName AND address_id = :addressId)", nativeQuery = true)
    void updateRestaurantStatusByRestaurantNameAndAddressId(@Param("restaurantName") String restaurantName,
                                                            @Param("addressId") long addressId,
                                                            @Param("restaurantStatus") String restaurantStatus);

}
