package com.example.hexagonal_architecture_spring_boot.infrastructure.exception;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String message){
        super(message);
    }
}
