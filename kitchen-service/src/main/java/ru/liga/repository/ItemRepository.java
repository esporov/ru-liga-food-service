package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.domain.item.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
