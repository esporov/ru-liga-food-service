package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.liga.domain.enitity.orderService.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Modifying
    @Query("update Customer c " +
            "set c.customerEmail = :email " +
            "where c.customerId = :id")
    void updateCustomerEmailById(@Param("id") long customerId, @Param("email") String email);
}
