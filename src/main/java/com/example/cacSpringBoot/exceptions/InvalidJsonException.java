package com.example.cacSpringBoot.exceptions;


public class InvalidJsonException extends RuntimeException{
    public InvalidJsonException(String message) {
        super(message);
    }
}
