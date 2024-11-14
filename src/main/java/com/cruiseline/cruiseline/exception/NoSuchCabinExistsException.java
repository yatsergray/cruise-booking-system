package com.cruiseline.cruiseline.exception;

public class NoSuchCabinExistsException extends Exception {

    public NoSuchCabinExistsException() {
    }

    public NoSuchCabinExistsException(String message) {
        super(message);
    }

    public NoSuchCabinExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchCabinExistsException(Throwable cause) {
        super(cause);
    }

    public NoSuchCabinExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
