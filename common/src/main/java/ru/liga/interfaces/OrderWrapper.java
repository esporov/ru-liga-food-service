package ru.liga.interfaces;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderWrapper<K, V> implements Serializable {
    private K order;
    private List<V> items;
}
