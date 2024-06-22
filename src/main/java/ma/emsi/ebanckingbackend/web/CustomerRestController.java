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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CustomerRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<CustomerDTO> customers(){
       return bankAccountService.listCustomer();
    }@GetMapping("/customers/search")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<CustomerDTO> searchcustomers(
            @RequestParam(name="keyword",defaultValue = "")String keyword){
        return bankAccountService.searchcustomers("%"+keyword+"%");
    }

    @GetMapping("/customers/{customerId}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public CustomerDTO getCustomer(@PathVariable Long customerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO)
    {
        return bankAccountService.saveCustomer(customerDTO);
    }
    @PutMapping("/customers/{customerId}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public CustomerDTO updateCustomer(@PathVariable Long customerId,@RequestBody CustomerDTO customerDTO){
        customerDTO.setId(customerId);
        return bankAccountService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/customers/{customerId}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void deleteCustomer( @PathVariable  Long customerId){
        bankAccountService.deleteCustomer(customerId);
    }






}
