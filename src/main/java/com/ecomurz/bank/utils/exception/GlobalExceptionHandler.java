package com.ecomurz.bank.utils.exception;

import com.ecomurz.bank.utils.response.GlobalResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<GlobalResponse> handleResourceNotFoundException(GlobalException ex) {
        GlobalResponse errorDetails = GlobalResponse.builder()
                .status(ex.getStatusCode())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatusCode.valueOf(ex.getStatusCode()));
    }
}
