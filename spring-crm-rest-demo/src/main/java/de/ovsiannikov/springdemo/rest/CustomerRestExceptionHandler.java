package de.ovsiannikov.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    // Add an exception handler for CustomerNotFoundException

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handlerException(CustomerNotFoundException e) {

        // create CustomerErrorResponse
        CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    // Add another exception handler ... to catch any exception (catch all)
}