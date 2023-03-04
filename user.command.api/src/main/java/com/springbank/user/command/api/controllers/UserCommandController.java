package com.springbank.user.command.api.controllers;

import com.springbank.user.command.api.commands.RegisterUserCommand;
import com.springbank.user.command.api.commands.RemoveUserCommand;
import com.springbank.user.command.api.commands.UpdateUserCommand;
import com.springbank.user.command.api.dto.UserCreationResponse;
import com.springbank.user.command.api.dto.UserRequest;
import com.springbank.user.core.exceptions.ExceptionResponse;
import com.springbank.user.core.models.User;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Validated
@RestController
@RequestMapping(path = "/api/v1/user")
public class UserCommandController {
    private final CommandGateway commandGateway;

    public UserCommandController(final CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public CompletableFuture<UserCreationResponse> createUser(@Valid @RequestBody UserRequest request) {
        final User user = new User(UUID.randomUUID().toString(), request.getFirstname(), request.getLastname(), request.getEmailAddress());
        final RegisterUserCommand command = new RegisterUserCommand(user);
        return this.commandGateway.send(command).thenApplyAsync(UserCreationResponse::new);
    }

    @PutMapping(path = "/{userId}")
    public CompletableFuture<Object> updateUser(@PathVariable(value = "userId") String userId, @Valid @RequestBody UserRequest request) {
        final User user = new User(userId, request.getFirstname(), request.getLastname(), request.getEmailAddress());
        final UpdateUserCommand command = new UpdateUserCommand(user);
        return this.commandGateway.send(command);
    }

    @DeleteMapping(path = "/{userId}")
    public CompletableFuture<Object> deleteUser(@PathVariable(value = "userId") String userId) {
        RemoveUserCommand command = new RemoveUserCommand(userId);
        return this.commandGateway.send(command);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        final Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        final ExceptionResponse response = new ExceptionResponse(httpStatus, "Validation error", errors);
        return new ResponseEntity<>(response, httpStatus);

    }

    @ExceptionHandler(CommandExecutionException.class)
    public ResponseEntity<ExceptionResponse> handleCommandExecutionException(CommandExecutionException exception) {
        final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        final ExceptionResponse response = new ExceptionResponse(httpStatus, exception.getMessage());
        return new ResponseEntity<>(response, httpStatus);
    }

}
