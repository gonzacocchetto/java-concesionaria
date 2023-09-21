package com.project.concesionaria.exception;

public class PurchaseNotExistException extends RuntimeException {

    public PurchaseNotExistException() {
        super("La factura no existe.");
    }
}
