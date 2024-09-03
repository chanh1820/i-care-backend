package com.example.icare.exception;

import com.example.icare.constant.MessageEnum;

public class BusinessRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -2054378323313999813L;

    private String errorCode;


    public BusinessRuntimeException() {
        super();
    }

    public BusinessRuntimeException(String message) {
        super(message);
    }

    public BusinessRuntimeException(Throwable cause) {
        super(cause);
    }

    public BusinessRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessRuntimeException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public BusinessRuntimeException(MessageEnum messageEnum) {
        super(messageEnum.getMessage());
        this.errorCode = messageEnum.getMessageCode();
    }
    public BusinessRuntimeException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
