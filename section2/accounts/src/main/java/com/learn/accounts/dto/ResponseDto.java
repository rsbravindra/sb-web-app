package com.learn.accounts.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class ResponseDto {
    @Schema(description = "Status code for the response")
    @JsonProperty("StatusCode")
    private String statusCode;

    @Schema(description = "Status message for the response")
    @JsonProperty("StatusMessage")
    private String statusMessage;
    public ResponseDto(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
