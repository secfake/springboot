package vn.tuananh.userdemo.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(NotFoundUser.class)
    public ErrorReponse handlerNotFoundException(NotFoundUser ex, WebRequest req) {
        return new ErrorReponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(DuplicateRecordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorReponse handlerDuplicateRecordException(DuplicateRecordException ex, WebRequest req) {
        return new ErrorReponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
