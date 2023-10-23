package ru.liga.repository;

import ru.liga.domain.enitity.customerService.customer.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {


    @Query("select ca " +
            "from CustomerAddress ca " +
            "where ca.addressId = :id")
    List<CustomerAddress> getAddressesByCustomerId(@Param("id") long customerId);

}
