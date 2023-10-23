package ru.liga.repository;

import domain.enitity.kitchenService.restaurant.Restaurant;
import domain.enitity.kitchenService.restaurant.RestaurantAddress;
import domain.enitity.kitchenService.restaurant.RestaurantStatus;
import domain.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> getRestaurantByRestaurantId(long restaurantId)
            throws ResourceNotFoundException;

    @Query("select ra " +
            "from RestaurantAddress ra " +
            "where ra.addressId = :id")
    Optional<RestaurantAddress> getRestaurantAddressByAddressId(@Param("id") long id)
            throws ResourceNotFoundException;

    @Query("select ra " +
            "from RestaurantAddress ra " +
            "where ra.restaurant.restaurantId = :id")
    List<RestaurantAddress> getAllRestaurantAddressesByRestaurantId(@Param("id") long id)
            throws ResourceNotFoundException;

    @Query("select ra " +
            "from RestaurantAddress ra " +
            "where ra.restaurant.restaurantName = :name")
    List<RestaurantAddress> getAllRestaurantAddressesByRestaurantName(@Param("name") String name)
            throws ResourceNotFoundException;

    @Query("select ra " +
            "from RestaurantAddress ra " +
            "where ra.restaurant.restaurantId = :id and ra.restaurantStatus = :status " +
            "order by ra.addressId")
    List<RestaurantAddress> getRestaurantAddressesByRestaurantIdAndRestaurantStatus(
            @Param("id") long addressId,
            @Param("status") RestaurantStatus restaurantStatus)
            throws ResourceNotFoundException;

    @Modifying
    @Query("update RestaurantAddress ra  " +
            "set ra.restaurantStatus = :restaurantStatus " +
            "where ra.addressId = :id")
    void updateRestaurantAddressStatusByAddressId(
            @Param("id") long id,
            @Param("restaurantStatus") RestaurantStatus restaurantStatus)
            throws ResourceNotFoundException;


//    void updateByRestaurantName(String restaurantName, String newRestaurantName);



    /*@Query(value = "UPDATE restaurant_address " +
            "SET restaurant_status = :restaurantStatus " +
            "WHERE  address_id = :addressId", nativeQuery = true)
    void updateRestaurantStatusByAddressId(@Param("addressId") long addressId,
                                           @Param("restaurantStatus") String restaurantStatus);*/

}
