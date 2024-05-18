package ma.emsi.ebanckingbackend.web;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.ebanckingbackend.dtos.AccountHistoryDTO;
import ma.emsi.ebanckingbackend.dtos.AccountOperationDTO;
import ma.emsi.ebanckingbackend.dtos.CustomerDTO;
import ma.emsi.ebanckingbackend.entities.Customer;
import ma.emsi.ebanckingbackend.exceptions.BalanceNotSufficientException;
import ma.emsi.ebanckingbackend.exceptions.BankAccountNotFoundException;
import ma.emsi.ebanckingbackend.exceptions.CustomerNotFoundException;
import ma.emsi.ebanckingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class CustomerRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/customers")
    public List<CustomerDTO> customers(){
       return bankAccountService.listCustomer();
    }

    @GetMapping("/customers/{customerId}")
    public CustomerDTO getCustomer(@PathVariable Long customerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO)
    {
        return bankAccountService.saveCustomer(customerDTO);
    }
    @PutMapping("/customers/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable Long customerId,@RequestBody CustomerDTO customerDTO){
        customerDTO.setId(customerId);
        return bankAccountService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomer( @PathVariable  Long customerId){
        bankAccountService.deleteCustomer(customerId);
    }


    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);
    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(
            @PathVariable String accountId,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam (name="size",defaultValue = "5")int size) throws BankAccountNotFoundException {

        return bankAccountService.getAccountHistory(accountId,page,size);
    }



}
