package pl.justmedia.controller;

import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.justmedia.service.exception.BusinessServiceException;
import pl.justmedia.service.exception.UserNotExistException;

import java.time.Instant;

@ControllerAdvice
final class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessServiceException.class)
    ResponseEntity<ErrorMessage> handleException(BusinessServiceException ex) {
        return ResponseEntity.badRequest() // -> status code = 400
                .body(new ErrorMessage(ex.getMessage(), Instant.now())); // JSON -> { message: "....", time: "..." }
    }

    @ExceptionHandler(UserNotExistException.class)
    ResponseEntity<ErrorMessage> handleException(UserNotExistException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND) // -> status code = 404
                .body(new ErrorMessage(ex.getMessage(), Instant.now()));
    }

    @Value
    private static class ErrorMessage {
        String message;
        Instant time;
    }
}
