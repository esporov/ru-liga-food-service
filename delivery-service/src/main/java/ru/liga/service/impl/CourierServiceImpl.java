package ru.liga.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.domain.exception.IllegalStatusException;
import ru.liga.service.CourierService;
import ru.liga.domain.courier.Courier;
import ru.liga.domain.courier.CourierStatus;
import ru.liga.domain.exception.ResourceNotFoundException;
import ru.liga.repository.CourierRepository;
import ru.liga.service.interfaces.EnumToStringConverter;

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
