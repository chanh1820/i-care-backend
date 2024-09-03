package com.example.icare.dto.api;

import java.util.Map;

import com.example.icare.constant.MessageConstant;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.http.HttpStatus;


@JsonInclude(Include.NON_NULL)
public class ResponseDTO<D> {

    private Map<String,String> headers;

    private String status = MessageConstant.STATUS_200;

    private String message;

    D data;

    @Override
    public String toString() {
        return "ResponseVO [status=" + status + ", message=" + message + ", data=" + data + "]";
    }

    public ResponseDTO(D data) {
        this.data = data;
    }

    public ResponseDTO() {
        // do nothing
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatus(int status) {
        this.status = String.valueOf(status);
    }

    public void setStatus(HttpStatus status) {
        this.status = String.valueOf(status.series().value());
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

}
