package com.learn.accounts.mapper;

import com.learn.accounts.dto.CustomerDto;
import com.learn.accounts.entity.Customer;

public class CustomerMapper {
    
    public static CustomerDto CustomerEntitytoCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }
    
    public static Customer CustomerDtoToCustomerEntity(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}
