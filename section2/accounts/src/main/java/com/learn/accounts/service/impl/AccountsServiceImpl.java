package com.learn.accounts.service.impl;

import com.learn.accounts.constants.AccountConstants;
import com.learn.accounts.dto.AccountsDto;
import com.learn.accounts.dto.CustomerDto;
import com.learn.accounts.entity.Accounts;
import com.learn.accounts.entity.Customer;
import com.learn.accounts.exception.CustomerAlreadyExistsException;
import com.learn.accounts.exception.ResourceNotFoundException;
import com.learn.accounts.mapper.AccountsMapper;
import com.learn.accounts.mapper.CustomerMapper;
import com.learn.accounts.repository.AccountsRepository;
import com.learn.accounts.repository.CustomerRepository;
import com.learn.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    AccountsServiceImpl(AccountsRepository accountsRepository, CustomerRepository customerRepository) {
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;
    }

    /**
     * Endpoint to create a new account.
     *
     * @param customerDto containing the customer details
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.CustomerDtoToCustomerEntity(customerDto, new Customer());
        Optional<Customer> existingCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());
        if (existingCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with mobile number " + customer.getMobileNumber() + " already exists");
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        customer.setUpdatedAt(LocalDateTime.now());
        customer.setUpdatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        Accounts savedAccounts = accountsRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * @param mobileNumber
     * @return
     */
    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "Mobile Number", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "CustomerId", customer.getCustomerId().toString())
        );
        CustomerDto customerDto = CustomerMapper.CustomerEntitytoCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.accountEntityToCustomerDto(accounts, new AccountsDto()));
        return customerDto;
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccountNumber = 1000000000L + new Random().nextInt();
        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        newAccount.setUpdatedAt(LocalDateTime.now());
        newAccount.setUpdatedBy("Anonymous");
        System.out.println("Result "+ ">" + newAccount);
        return newAccount;
    }
}
