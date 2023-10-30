package ru.liga.service;


import ru.liga.domain.enitity.deliveryService.courier.Courier;

import java.util.List;

public interface CourierService {

    Courier getCourierByCourierId(long courierId);

    List<Courier> getAllCourier();

    List<Courier> getAllCourierByCourierStatus(String courierStatus);

    Courier updateCourierStatusByCourierId(long courierId, String status);
}
