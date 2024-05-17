package ma.emsi.ebanckingbackend.repositories;

import ma.emsi.ebanckingbackend.entities.AccountOperation;
import ma.emsi.ebanckingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
}
