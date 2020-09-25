package com.challenge.mutant.exception;

import com.challenge.mutant.exception.api.ApiError;
import com.challenge.mutant.exception.entity.NotMutantException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ApiError apiError = new ApiError()
        .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        .setTimestamp(LocalDateTime.now())
        .setMessage(ex.getMessage())
        .setDebugMessage(ex.getLocalizedMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(NotMutantException.class)
    protected ResponseEntity<Object> handleNotMutantException(NotMutantException ex) {
        ApiError apiError = new ApiError()
                .setStatus(HttpStatus.FORBIDDEN)
                .setTimestamp(LocalDateTime.now())
                .setMessage(ex.getMessage())
                .setDebugMessage(ex.getLocalizedMessage());
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}