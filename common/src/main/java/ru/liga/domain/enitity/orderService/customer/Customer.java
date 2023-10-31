package ru.liga.domain.enitity.orderService.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "create_date")
    private Date createDate;

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) return false;
        if (!Objects.equals(phoneNumber, customer.phoneNumber))
            return false;
        if (!Objects.equals(customerEmail, customer.customerEmail))
            return false;
        return Objects.equals(createDate, customer.createDate);
    }

    @Override
    public int hashCode() {
        int result = (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (customerEmail != null ? customerEmail.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
