package ma.emsi.ebanckingbackend.services;

import ma.emsi.ebanckingbackend.dtos.*;
import ma.emsi.ebanckingbackend.entities.BankAccount;
import ma.emsi.ebanckingbackend.entities.CurrentAccount;
import ma.emsi.ebanckingbackend.entities.Customer;
import ma.emsi.ebanckingbackend.entities.SavingAccount;
import ma.emsi.ebanckingbackend.exceptions.BalanceNotSufficientException;
import ma.emsi.ebanckingbackend.exceptions.BankAccountNotFoundException;
import ma.emsi.ebanckingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customer);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDarft, long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> searchcustomers(String keyword);
    CustomerDTO getCustomer(Long customerID) throws CustomerNotFoundException;

    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomer();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId,double amount,String description) throws BalanceNotSufficientException, BankAccountNotFoundException;
    void credit(String accountId,double amount,String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource,String accountIdDestinetion,double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;
    public List<BankAccountDTO> bankAccountList();

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
}
