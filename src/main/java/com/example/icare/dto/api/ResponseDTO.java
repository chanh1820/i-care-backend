package com.example.icare.dto.api;

import java.util.Map;

import com.example.icare.constant.MessageConstant;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.ToString;
import org.springframework.http.HttpStatus;


@JsonInclude(Include.NON_NULL)
@ToString
public class ResponseDTO<D> {

    private String statusCode = MessageConstant.STATUS_200;

    private String errorCode;

    private String message;

    private D data;


    public ResponseDTO(D data) {
        this.data = data;
    }

    public ResponseDTO() {
        // do nothing
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
