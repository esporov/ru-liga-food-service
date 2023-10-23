package ru.liga.repository;

import ru.liga.domain.enitity.customerService.customer.Customer;
import ru.liga.domain.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c " +
            "from Customer c " +
            "where c.customerId = :id")
    Optional<Customer> getCustomerById(@Param("id") long customerId) throws ResourceNotFoundException;

    @Modifying
    @Query("update Customer c " +
            "set c.customerEmail = :email " +
            "where c.customerId = :id")
    void updateCustomerEmailById(@Param("id") long customerId, @Param("email") String email);
}
