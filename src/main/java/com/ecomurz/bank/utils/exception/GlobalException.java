package com.ecomurz.bank.utils.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@EqualsAndHashCode(callSuper = true)
public class GlobalException extends RuntimeException {

    private Integer statusCode;
    private String message;

    public GlobalException(Integer statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }
}
