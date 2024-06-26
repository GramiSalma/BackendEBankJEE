package ma.emsi.ebanckingbackend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.ebanckingbackend.enums.AccountStatus;

import java.util.Date;
import java.util.List;




@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",length=4)

@Data
@NoArgsConstructor
@AllArgsConstructor

public  abstract class BankAccount {
  @Id
//@GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    private double balance;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy="bankAccount",fetch = FetchType.LAZY)
    private List<AccountOperation> accountOperations;

}
