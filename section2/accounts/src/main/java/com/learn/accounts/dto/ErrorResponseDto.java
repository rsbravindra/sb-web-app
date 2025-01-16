package com.learn.accounts.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public class ErrorResponseDto {

    @Schema(description = "API Path", example = "/accounts")
    @JsonProperty("ApiPath")
    private String apiPath;

    @JsonProperty("ErrorCode")
    @Schema(description = "Error Code", example = "200")
    private HttpStatus errorCode;

    @Schema(description = "Error Message", example = "Success")
    @JsonProperty("ErrorMessage")
    private String errorMessage;

    @Schema(description = "Error Date Time", example = "2023-01-01T00:00:00")
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
