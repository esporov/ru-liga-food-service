package ru.liga.batisMapper;

import org.apache.ibatis.annotations.*;
import ru.liga.domain.enitity.kitchenService.restaurant.Restaurant;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantAddress;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantStatus;

import java.util.List;
import java.util.Optional;

@Mapper
public interface RestaurantMapperBatis {

    @Select(value = "select * from restaurant_address ra " +
            "left join restaurants r " +
            "using (restaurant_id) " +
            "where ra.city = #{city} and work_status = #{workStatus}")
    @Results(value = {
            @Result(property = "addressId", column = "address_id", id = true),
            @Result(property = "streetName", column = "street_name"),
            @Result(property = "city", column = "city"),
            @Result(property = "dateOfAdd", column = "date_of_add"),
            @Result(property = "restaurantStatus", column = "work_status",
                    javaType = RestaurantStatus.class),
            @Result(property = "restaurant", column = "restaurant_id",
                    one = @One(select = "getRestaurantById"), javaType = Restaurant.class),
    })
    List<RestaurantAddress> getAllRestaurantAddressByCityAndByStatus(@Param("city")String city,
                                                                     @Param("workStatus") RestaurantStatus restaurantStatus);

    @Select("select r.* " +
            "from restaurants r " +
            "where r.restaurant_id = #{id}")
    @Results(value = {
            @Result(property = "restaurantId", column = "restaurant_id", id = true),
            @Result(property = "restaurantName", column = "restaurant_name")
    })
    Optional<Restaurant> getRestaurantById(@Param("id") long id);

}
