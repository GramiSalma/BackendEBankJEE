package ma.emsi.ebanckingbackend.services;


import jakarta.transaction.Transactional;
import ma.emsi.ebanckingbackend.entities.BankAccount;
import ma.emsi.ebanckingbackend.entities.CurrentAccount;
import ma.emsi.ebanckingbackend.entities.SavingAccount;
import ma.emsi.ebanckingbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void consulter(){
        BankAccount bankAccount=bankAccountRepository.findById("001230de-4add-4eaa-9dd1-f545e156ab56").orElse(null);
        if(bankAccount!=null){
            System.out.println("***********************************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());

            if(bankAccount instanceof CurrentAccount){
                System.out.println( "OverDraft=>"+((CurrentAccount) bankAccount).getOverDraft()) ;
            }else if(bankAccount instanceof SavingAccount){
                System.out.println( "OverDraft=>"+((SavingAccount) bankAccount).getInterestRate()) ;
            }
            bankAccount.getAccountOperations().forEach(
                    op->{
                        System.out.println("=======================");
                        System.out.println(op.getType());
                        System.out.println(op.getOperationDate());
                        System.out.println(op.getAmount());



                    }
            );}
    }

}
