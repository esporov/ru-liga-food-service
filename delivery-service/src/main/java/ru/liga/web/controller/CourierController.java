package ru.liga.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.domain.courier.Courier;
import ru.liga.service.CourierService;
import ru.liga.web.dto.CourierDto;
import ru.liga.web.mapper.CoordinateMapper;
import ru.liga.web.mapper.CourierMapper;

import java.util.List;

@RestController
@RequestMapping("/delivery-api")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;
    private final CourierMapper courierMapper;
    private final CoordinateMapper coordinateMapper;

    @GetMapping("/v1.0/courier")
    public ResponseEntity<CourierDto> getCourierByCourierId(@RequestParam("id") long courierId) {
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

    @GetMapping
    public ResponseEntity<List<CourierDto>> getCouriersByCourierStatus(String courierStatus) {
        List<Courier> couriers = courierService.getCouriersByCourierStatus(courierStatus);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(courierMapper.toDto(couriers));
    }
}
