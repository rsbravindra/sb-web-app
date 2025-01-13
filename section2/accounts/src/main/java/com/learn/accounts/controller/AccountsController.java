package com.learn.accounts.controller;

import com.learn.accounts.constants.AccountConstants;
import com.learn.accounts.dto.CustomerDto;
import com.learn.accounts.dto.ResponseDto;
import com.learn.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountsController {

    private IAccountService accountService;

    public AccountsController(@Autowired IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Endpoint to create a new account.
     *
     * @param customerDto containing the customer details
     * @return A response with the status and message
     */
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        accountService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @GetMapping(value = "/fetch")
    public ResponseEntity<CustomerDto> fetchAccount(@RequestParam String mobileNumber) {
        CustomerDto customerDto = accountService.fetchAccount(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }

}
