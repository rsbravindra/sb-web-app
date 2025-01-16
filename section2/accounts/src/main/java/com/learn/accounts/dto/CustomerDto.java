package com.learn.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
public class CustomerDto {

    @NotEmpty(message = "name should not be null or empty" )// makes field as mandatory
    @Size(min = 5, max = 30, message = "name should be between 5 and 30 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "email should not be null or empty")
    @Email(message = "email should be valid")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "mobile number should not be null or empty")
    @Pattern(regexp = "[0-9]{10}", message = "mobile number should be 10 digits")
    @Column(name = "mobile_number")
    private String mobileNumber;

    private AccountsDto accountsDto;


    public AccountsDto getAccountsDto() {
        return accountsDto;
    }

    public void setAccountsDto(AccountsDto accountsDto) {
        this.accountsDto = accountsDto;
    }


    public CustomerDto() {

    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
