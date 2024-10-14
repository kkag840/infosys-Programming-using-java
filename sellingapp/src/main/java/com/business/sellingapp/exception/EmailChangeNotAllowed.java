package com.business.sellingapp.exception;


public class EmailChangeNotAllowed extends RuntimeException {
    public EmailChangeNotAllowed(String message) {
        super(message);
    }
}
