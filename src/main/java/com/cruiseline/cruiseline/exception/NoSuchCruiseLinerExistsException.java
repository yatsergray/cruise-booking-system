package com.cruiseline.cruiseline.exception;

public class NoSuchCruiseLinerExistsException extends Exception {

    public NoSuchCruiseLinerExistsException() {
    }

    public NoSuchCruiseLinerExistsException(String message) {
        super(message);
    }

    public NoSuchCruiseLinerExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchCruiseLinerExistsException(Throwable cause) {
        super(cause);
    }

    public NoSuchCruiseLinerExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
