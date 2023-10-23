package ru.liga.service.impl;

import domain.enitity.deliveryService.courier.Courier;
import domain.enitity.deliveryService.courier.CourierStatus;
import domain.exception.IllegalStatusException;
import domain.exception.ResourceNotFoundException;
import interfaces.EnumToStringConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.service.CourierService;
import ru.liga.repository.CourierRepository;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService, EnumToStringConverter {

    private final CourierRepository courierRepository;

    @Override
    public Courier getCourierByCourierId(long id) {
        try {
            return courierRepository.getCourierByCourierId(id)
                    .orElseThrow(()->new ResourceNotFoundException("Курьера с id = " + id + " не существует."));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Courier> getAllCourier() {
        return courierRepository.findAll();
    }

    @Override
    public List<Courier> getCouriersByCourierStatus(String courierStatus) {
        try {
            CourierStatus status = CourierStatus.valueOf(courierStatus);
            return courierRepository.getCouriersByCourierStatus(status);
        } catch (IllegalArgumentException e) {
            String enums = enumToString(CourierStatus.class);
            String message = String.format("Указан неверный статус. Возможны варианты: %s", enums);
            throw new IllegalStatusException(message, e);
        }
    }
}
