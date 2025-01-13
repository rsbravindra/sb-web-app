package com.learn.accounts.service;

import com.learn.accounts.dto.CustomerDto;

public interface IAccountService {
    /**
     * Endpoint to create a new account.
     *
     * @param customerDto containing the customer details
     */
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);
}
