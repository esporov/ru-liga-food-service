package ru.liga.domain.exception;

public class ItemNotFoundException extends ResourceNotFoundException{

    public ItemNotFoundException(String message) {
        super(message);
    }
}
