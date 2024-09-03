package com.example.icare.constant;

public enum MessageEnum {

    ERR_ACCOUNT_EXISTING("ERR_1OO1", "Account already exists"),
    ERR_ACCOUNT_NOT_FOUND("ERR_1OO2", "Account not found"),
    ERR_PASS_WORD_NOT_MACTH("ERR_1OO3", "Password not match");


    private String messageCode;
    private String message;

    MessageEnum(String messageCode, String message) {
        this.messageCode = messageCode;
        this.message = message;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
