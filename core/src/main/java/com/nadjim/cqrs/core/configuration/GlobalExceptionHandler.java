package com.nadjim.cqrs.core.configuration;

import com.nadjim.cqrs.core.exceptions.BaseException;
import com.nadjim.cqrs.core.models.ValidationError;
import org.axonframework.commandhandling.CommandExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseException> handleValidationExceptions(MethodArgumentNotValidException ex) {
        final List<ValidationError> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.add(new ValidationError(fieldName, errorMessage));
        });
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        final BaseException response = new BaseException(httpStatus, "Validation error", errors);
        return new ResponseEntity<>(response, httpStatus);

    }

    @ExceptionHandler(CommandExecutionException.class)
    public ResponseEntity<BaseException> handleCommandExecutionException(CommandExecutionException exception) {
        final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        final BaseException response = new BaseException(httpStatus, exception.getMessage());
        return new ResponseEntity<>(response, httpStatus);
    }
}
