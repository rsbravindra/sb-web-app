package com.learn.accounts.repository;

import com.learn.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    /**
     * Finds a customer by their mobile number.
     *
     * @param mobileNumber the mobile number to search for
     * @return an Optional containing the customer if found, otherwise an empty Optional
     */
    Optional<Customer> findByMobileNumber(String mobileNumber);
}
