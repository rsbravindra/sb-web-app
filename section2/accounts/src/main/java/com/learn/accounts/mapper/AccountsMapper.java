package com.learn.accounts.mapper;

import com.learn.accounts.dto.AccountsDto;
import com.learn.accounts.entity.Accounts;

public class AccountsMapper {
    public static AccountsDto accountEntityToCustomerDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Accounts accountsDtoToAccountsEntity(AccountsDto accountsDto, Accounts accounts) {
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        return accounts;
    }
}
