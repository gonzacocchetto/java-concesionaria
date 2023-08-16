package com.project.concesionaria.exception;

public class EmailValidationException extends RuntimeException {

    public EmailValidationException() {
        super("El mail no tiene el formato requerido.");
    }

}
