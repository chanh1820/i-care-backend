package com.example.icare.exception.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseErrorDTO<D> {

    private String statusCode;

    private String errorCode;

    private String message;

    private D data;

    public ResponseErrorDTO() {
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}

