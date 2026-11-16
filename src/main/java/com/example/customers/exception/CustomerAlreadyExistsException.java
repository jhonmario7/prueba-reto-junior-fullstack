package com.example.customers.exception;

public class CustomerAlreadyExistsException extends RuntimeException {

    public CustomerAlreadyExistsException(String email){
        super("Ya existe un cliente con el email: " + email);
    }
    
}
