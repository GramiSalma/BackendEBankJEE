package ma.emsi.ebanckingbackend.repositories;

import ma.emsi.ebanckingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
