package ru.liga.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.liga.domain.exception.ExceptionBody;
import ru.liga.domain.exception.RestaurantNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RestaurantNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionBody handleResourceNotFound(RestaurantNotFoundException e) {
        return new ExceptionBody("Ресторан не найден");
    }
}
