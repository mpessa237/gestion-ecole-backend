package com.example.Ecole_gestion.exception;

public class RessourceNotFoundException extends RuntimeException{
    public RessourceNotFoundException(String message) {
        super(message);
    }
}
