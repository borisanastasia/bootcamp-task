package by.itacademy.bootcamp.task.presentation;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ErrorResponse handleNotFound(Exception exception) {
        return ErrorResponse.create(exception, NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ErrorResponse handleBadRequest(Exception exception) {
        return ErrorResponse.create(exception, BAD_REQUEST, exception.getMessage());
    }
}
