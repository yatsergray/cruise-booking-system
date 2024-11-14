package com.cruiseline.cruiseline.exception;

public class NoSuchCabinClassExistsException extends Exception {

    public NoSuchCabinClassExistsException() {
    }

    public NoSuchCabinClassExistsException(String message) {
        super(message);
    }

    public NoSuchCabinClassExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchCabinClassExistsException(Throwable cause) {
        super(cause);
    }

    public NoSuchCabinClassExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
