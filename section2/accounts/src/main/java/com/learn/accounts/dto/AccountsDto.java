package com.learn.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@AllArgsConstructor
public class AccountsDto {

    @Pattern(regexp = "[0-9]{10}", message = "mobile number should be 10 digits")
    @NotEmpty(message = "account number should not be null or empty")
    @Column(name = "account_number")
    private Long accountNumber;

    @NotEmpty(message = "account type should not be null or empty")
    @Column(name = "account_type")
    private String accountType;

    @NotEmpty(message = "branch address should not be null or empty")
    @Column(name = "branch_address")
    private String branchAddress;

    public AccountsDto() {

    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }


}
