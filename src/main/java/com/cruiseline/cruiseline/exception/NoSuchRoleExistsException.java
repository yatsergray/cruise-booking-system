package com.cruiseline.cruiseline.exception;

public class NoSuchRoleExistsException extends Exception {

    public NoSuchRoleExistsException() {
    }

    public NoSuchRoleExistsException(String message) {
        super(message);
    }

    public NoSuchRoleExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchRoleExistsException(Throwable cause) {
        super(cause);
    }

    public NoSuchRoleExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
