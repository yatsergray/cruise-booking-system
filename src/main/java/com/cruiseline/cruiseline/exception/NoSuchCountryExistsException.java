package com.cruiseline.cruiseline.exception;

public class NoSuchCountryExistsException extends Exception {

    public NoSuchCountryExistsException() {
    }

    public NoSuchCountryExistsException(String message) {
        super(message);
    }

    public NoSuchCountryExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchCountryExistsException(Throwable cause) {
        super(cause);
    }

    public NoSuchCountryExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
