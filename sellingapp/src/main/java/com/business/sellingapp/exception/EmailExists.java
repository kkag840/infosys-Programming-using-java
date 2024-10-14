package com.business.sellingapp.exception;

public class EmailExists extends RuntimeException {
    public EmailExists(String message) {
        super(message);
    }
}
