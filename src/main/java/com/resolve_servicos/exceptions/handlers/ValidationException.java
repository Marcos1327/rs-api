package com.resolve_servicos.exceptions.handlers;

public class ValidationException extends RuntimeException {

    public ValidationException(String mensage){
        super(mensage);
    }
}
