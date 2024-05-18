package ma.emsi.ebanckingbackend.dtos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.ebanckingbackend.entities.BankAccount;
import ma.emsi.ebanckingbackend.enums.OperationType;

import java.util.Date;



@Data

public class AccountOperationDTO {

    private Long id;
    private Date operationDate;
    private  double amount;
    private OperationType type;
    private String description;
}
