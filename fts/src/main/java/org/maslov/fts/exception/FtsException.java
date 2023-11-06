package org.maslov.fts.exception;

public class FtsException extends RuntimeException{

    public FtsException(String message) {
        super(message);
    }

    public FtsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FtsException(Throwable cause) {
        super(cause);
    }

    public FtsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
