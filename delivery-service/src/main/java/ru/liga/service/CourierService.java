package ru.liga.service;

import ru.liga.domain.courier.Courier;
import ru.liga.domain.courier.CourierStatus;

import java.util.List;

public interface CourierService {

    Courier getCourierByCourierId(long courierId);

     List<Courier> getAllCourier();

    List<Courier> getCouriersByCourierStatus(String courierStatus);
}
