package com.cruiseline.cruiseline.exception;

public class NoSuchCityExistsException extends Exception {

    public NoSuchCityExistsException() {
    }

    public NoSuchCityExistsException(String message) {
        super(message);
    }

    public NoSuchCityExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchCityExistsException(Throwable cause) {
        super(cause);
    }

    public NoSuchCityExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
