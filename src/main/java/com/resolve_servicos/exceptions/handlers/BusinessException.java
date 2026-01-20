package com.resolve_servicos.exceptions.handlers;

public class BusinessException extends RuntimeException{

    public BusinessException(String mensage){
        super(mensage);
    }
}
