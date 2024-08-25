package com.ecomurz.bank.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class EmailHasRegisterException extends GlobalException {
    public EmailHasRegisterException(String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }
}
