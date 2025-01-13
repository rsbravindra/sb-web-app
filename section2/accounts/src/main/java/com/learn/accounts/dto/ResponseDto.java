package com.learn.accounts.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDto {
    @JsonProperty("StatusCode")
    private String statusCode;
    @JsonProperty("StatusMessage")
    private String statusMessage;
    public ResponseDto(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
