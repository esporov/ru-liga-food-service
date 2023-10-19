package ru.liga.service.interfaces;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface EnumToStringConverter  {
    default  <E extends Enum<E>> String enumToString(Class<E> e) {
        return Stream.of(e.getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.joining(", ", "", "."));
    }
}
