package com.nadjim.cqrs.user.command.api.controllers;

import com.nadjim.cqrs.user.command.api.models.UserCreationRequest;
import com.nadjim.cqrs.user.command.api.models.UserCreationResponse;
import com.nadjim.cqrs.user.command.api.models.UserUpdateRequest;
import com.nadjim.cqrs.user.core.commands.RegisterUserCommand;
import com.nadjim.cqrs.user.core.commands.RemoveUserCommand;
import com.nadjim.cqrs.user.core.commands.UpdateUserCommand;
import com.nadjim.cqrs.user.core.models.User;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public CompletableFuture<UserCreationResponse> createUser(@Valid @RequestBody UserCreationRequest request) {
        final RegisterUserCommand command = RegisterUserCommand.builder()
                .aggregateIdentifier(UUID.randomUUID().toString())
                .emailAddress(request.getEmailAddress())
                .lastname(request.getLastname())
                .firstname(request.getFirstname())
                .build();
        return this.commandGateway.send(command).thenApplyAsync(UserCreationResponse::new);
    }

    @PutMapping(path = "/{userId}")
    public CompletableFuture<Object> updateUser(@PathVariable(value = "userId") String userId, @Valid @RequestBody UserUpdateRequest request) {
        final UpdateUserCommand command = UpdateUserCommand.builder()
                .aggregateIdentifier(userId)
                .lastname(request.getLastname())
                .firstname(request.getFirstname())
                .active(request.getActive())
                .build();
        return this.commandGateway.send(command);
    }

    @DeleteMapping(path = "/{userId}")
    public CompletableFuture<Object> deleteUser(@PathVariable(value = "userId") String userId) {
        final RemoveUserCommand command = RemoveUserCommand.builder()
                .aggregateIdentifier(userId)
                .build();
        return this.commandGateway.send(command);
    }

}
