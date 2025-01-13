package com.learn.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resoureName;
    private String fieldName;
    private String fieldValue;
    public ResourceNotFoundException(String resoureName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : '%s'", resoureName, fieldName, fieldValue));
    }
}
