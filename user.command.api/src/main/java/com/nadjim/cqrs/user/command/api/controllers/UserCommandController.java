package com.nadjim.cqrs.user.command.api.controllers;

import com.nadjim.cqrs.user.command.api.models.UserCreationResponse;
import com.nadjim.cqrs.user.command.api.models.UserRequest;
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
    public CompletableFuture<UserCreationResponse> createUser(@Valid @RequestBody UserRequest request) {
        final User user = User.builder()
                .id(UUID.randomUUID().toString())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .emailAddress(request.getEmailAddress())
                .build();
        final RegisterUserCommand command = new RegisterUserCommand(user);
        return this.commandGateway.send(command).thenApplyAsync(UserCreationResponse::new);
    }

    @PutMapping(path = "/{userId}")
    public CompletableFuture<Object> updateUser(@PathVariable(value = "userId") String userId, @Valid @RequestBody UserRequest request) {
        final User user = User.builder()
                .id(userId)
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .emailAddress(request.getEmailAddress())
                .build();
        final UpdateUserCommand command = new UpdateUserCommand(user);
        return this.commandGateway.send(command);
    }

    @DeleteMapping(path = "/{userId}")
    public CompletableFuture<Object> deleteUser(@PathVariable(value = "userId") String userId) {
        final RemoveUserCommand command = new RemoveUserCommand(userId);
        return this.commandGateway.send(command);
    }

}
