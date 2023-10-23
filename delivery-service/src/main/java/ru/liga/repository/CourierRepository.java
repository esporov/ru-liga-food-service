package ru.liga.repository;

import ru.liga.domain.enitity.deliveryService.courier.Courier;
import ru.liga.domain.enitity.deliveryService.courier.CourierStatus;
import ru.liga.domain.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface CourierRepository extends JpaRepository<Courier,Long> {

    @Query("select c " +
            "from Courier c " +
            "where c.courierId = :id")
    Optional<Courier> getCourierByCourierId(@Param("id") long courierId) throws ResourceNotFoundException;

    @Query("select c from Courier c where c.courierStatus = :status")
    List<Courier> getCouriersByCourierStatus(@Param("status") CourierStatus status);
}
