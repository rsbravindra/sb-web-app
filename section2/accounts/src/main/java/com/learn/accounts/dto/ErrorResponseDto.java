package com.learn.accounts.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public class ErrorResponseDto {

    @JsonProperty("ApiPath")
    private String apiPath;
    @JsonProperty("ErrorCode")
    private HttpStatus errorCode;
    @JsonProperty("ErrorMessage")
    private String errorMessage;
    @JsonProperty("ErrorDateTime")
    private LocalDateTime errorDateTime;

    public ErrorResponseDto(String apiPath, HttpStatus errorCode, String errorMessage, LocalDateTime errorDateTime) {
        this.apiPath = apiPath;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDateTime = errorDateTime;
    }
    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getErrorDateTime() {
        return errorDateTime;
    }

    public void setErrorDateTime(LocalDateTime errorDateTime) {
        this.errorDateTime = errorDateTime;
    }


}
