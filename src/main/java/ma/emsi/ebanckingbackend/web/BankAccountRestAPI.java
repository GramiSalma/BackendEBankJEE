package ma.emsi.ebanckingbackend.web;


import lombok.AllArgsConstructor;
import ma.emsi.ebanckingbackend.dtos.BankAccountDTO;
import ma.emsi.ebanckingbackend.dtos.CreditDTO;
import ma.emsi.ebanckingbackend.dtos.DebitDTO;
import ma.emsi.ebanckingbackend.dtos.TransferRequestDTO;
import ma.emsi.ebanckingbackend.exceptions.BalanceNotSufficientException;
import ma.emsi.ebanckingbackend.exceptions.BankAccountNotFoundException;
import ma.emsi.ebanckingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @AllArgsConstructor
    public class BankAccountRestAPI {
        private BankAccountService bankAccountService;

        @GetMapping("/accounts/{accountId}")
        public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
            return bankAccountService.getBankAccount(accountId);
        }


        @GetMapping("/accounts")
        public List<BankAccountDTO> listAccounts(){
            return bankAccountService.bankAccountList();
        }


    @PostMapping("/accounts/debit")
    public DebitDTO debit(@RequestBody DebitDTO debitDTO) throws BankAccountNotFoundException, BalanceNotSufficientException {
        this.bankAccountService.debit(debitDTO.getAccountId(),debitDTO.getAmount(),debitDTO.getDescription());
        return debitDTO;
    }
    @PostMapping("/accounts/credit")
    public CreditDTO credit(@RequestBody CreditDTO creditDTO) throws BankAccountNotFoundException {
        this.bankAccountService.credit(creditDTO.getAccountId(),creditDTO.getAmount(),creditDTO.getDescription());
        return creditDTO;
    }
    @PostMapping("/accounts/transfer")
    public void transfer(@RequestBody TransferRequestDTO transferRequestDTO) throws BankAccountNotFoundException, BalanceNotSufficientException {
        this.bankAccountService.transfer(
                transferRequestDTO.getAccountSource(),
                transferRequestDTO.getAccountDestination(),
                transferRequestDTO.getAmount());
    }


    }
