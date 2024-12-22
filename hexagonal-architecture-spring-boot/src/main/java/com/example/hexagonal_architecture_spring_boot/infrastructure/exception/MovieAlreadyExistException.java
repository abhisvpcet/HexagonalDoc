package com.example.hexagonal_architecture_spring_boot.infrastructure.exception;


public class MovieAlreadyExistException extends RuntimeException {

    public MovieAlreadyExistException(String msg){
        super(msg);
    }



}
