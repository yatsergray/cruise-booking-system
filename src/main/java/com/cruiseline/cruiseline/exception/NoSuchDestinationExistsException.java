package com.cruiseline.cruiseline.exception;

public class NoSuchDestinationExistsException extends Exception {

    public NoSuchDestinationExistsException() {
    }

    public NoSuchDestinationExistsException(String message) {
        super(message);
    }

    public NoSuchDestinationExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchDestinationExistsException(Throwable cause) {
        super(cause);
    }

    public NoSuchDestinationExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
