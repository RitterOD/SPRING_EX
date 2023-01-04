package org.maslov.template.infra.exception;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException{
    AppExceptionCode code;
    AppExceptionSource source;

    public AppException(AppExceptionCode code, AppExceptionSource source) {
        this.code = code;
        this.source = source;
    }

    public AppException(String message, AppExceptionCode code, AppExceptionSource source) {
        super(message);
        this.code = code;
        this.source = source;
    }

    public AppException(String message, Throwable cause, AppExceptionCode code, AppExceptionSource source) {
        super(message, cause);
        this.code = code;
        this.source = source;
    }
}
