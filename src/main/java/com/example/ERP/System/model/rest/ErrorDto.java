package com.example.ERP.System.model.rest;

public class ErrorDto {
    private String errorCode;
    private String description;
    private ResponseMessages responseMessages;

    public ErrorDto() {
    }

    public ErrorDto(String errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ResponseMessages getResponseMessages() {
        return responseMessages;
    }

    public void setResponseMessages(ResponseMessages responseMessages) {
        this.responseMessages = responseMessages;
    }
}
