package com.learn.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Schema(
    name = "Customer",
    description = "Schema to hold Customer and Account information"
)
@AllArgsConstructor
public class CustomerDto {

    @Schema(description = "Name of the Customer", required = true, example = "John Doe")
    @NotEmpty(message = "name should not be null or empty" )// makes field as mandatory
    @Size(min = 5, max = 30, message = "name should be between 5 and 30 characters")
    @Column(name = "name")
    private String name;

    @Schema(description = "Email of the Customer", required = true, example = "WlK9O@example.com")
    @NotEmpty(message = "email should not be null or empty")
    @Email(message = "email should be valid")
    @Column(name = "email")
    private String email;

    @Schema(description = "Mobile number of the Customer", required = true, example = "1234567890")
    @NotEmpty(message = "mobile number should not be null or empty")
    @Pattern(regexp = "[0-9]{10}", message = "mobile number should be 10 digits")
    @Column(name = "mobile_number")
    private String mobileNumber;

    @Schema(description = "Accounts of the Customer", required = true)
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
