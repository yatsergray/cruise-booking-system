package com.cruiseline.cruiseline.exception;

public class NoSuchCruiseExistsException extends Exception {

    public NoSuchCruiseExistsException() {
    }

    public NoSuchCruiseExistsException(String message) {
        super(message);
    }

    public NoSuchCruiseExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchCruiseExistsException(Throwable cause) {
        super(cause);
    }

    public NoSuchCruiseExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
