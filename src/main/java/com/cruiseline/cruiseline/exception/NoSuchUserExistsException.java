package com.cruiseline.cruiseline.exception;

public class NoSuchUserExistsException extends Exception {

    public NoSuchUserExistsException() {
    }

    public NoSuchUserExistsException(String message) {
        super(message);
    }

    public NoSuchUserExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchUserExistsException(Throwable cause) {
        super(cause);
    }

    public NoSuchUserExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
