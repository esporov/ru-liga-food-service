package ru.liga.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.liga.domain.exception.ExceptionBody;
import ru.liga.domain.exception.IllegalStatusException;
import ru.liga.domain.exception.ItemNotFoundException;
import ru.liga.domain.exception.RestaurantNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RestaurantNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionBody handleRestaurantNotFound(RestaurantNotFoundException e) {
        return new ExceptionBody(e.getMessage());
    }

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionBody handleItemNotFound(ItemNotFoundException e) {
        return new ExceptionBody(e.getMessage());
    }

    @ExceptionHandler(IllegalStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleIllegalStatus(IllegalStatusException e) {
        return new ExceptionBody(e.getMessage());
    }
}
