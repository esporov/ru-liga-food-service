package ru.liga.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.liga.domain.enitity.deliveryService.courier.Courier;
import ru.liga.service.CourierService;
import ru.liga.web.dto.delivery.CourierDto;
import ru.liga.web.mapper.delivery.CourierMapper;

import java.util.List;

@Validated
@RestController
@RequestMapping("/delivery-api")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;
    private final CourierMapper courierMapper;

    @GetMapping("/v1.0/courier/id/{id}")
    public ResponseEntity<CourierDto> getCourierByCourierId(@PathVariable("id") long courierId) {
        var courier = courierService.getCourierByCourierId(courierId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(courierMapper.toDto(courier));
    }

    @GetMapping("/v1.0/couriers")
    public ResponseEntity<List<CourierDto>> getAllCourier() {
        List<Courier> couriers = courierService.getAllCourier();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(courierMapper.toDto(couriers));
    }

    @GetMapping("/v1.0/couriers/status/{status}")
    public ResponseEntity<List<CourierDto>> getCouriersByCourierStatus(@PathVariable("status") String courierStatus) {
        List<Courier> couriers = courierService.getAllCourierByCourierStatus(courierStatus);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(courierMapper.toDto(couriers));
    }

    @PatchMapping("/v1.0/courier/id/{id}/status/{status}")
    ResponseEntity<CourierDto> updateCourierStatusByCourierId(@PathVariable("id") long id,
                                                           @PathVariable("status") String courierStatus) {
        var courier = courierService.updateCourierStatusByCourierId(id, courierStatus);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(courierMapper.toDto(courier));

    }
}
