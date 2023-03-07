package com.springbank.user.query.api.handlers.impl;

import com.nadjim.cqrs.user.core.events.UserRegisteredEvent;
import com.nadjim.cqrs.user.core.events.UserRemovedEvent;
import com.nadjim.cqrs.user.core.events.UserUpdatedEvent;
import com.nadjim.cqrs.user.core.models.User;
import com.springbank.user.query.api.handlers.UserEventHandler;
import com.springbank.user.query.api.repositories.UserRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
public class UserEventHandlerImpl implements UserEventHandler {

    private final UserRepository userRepository;

    public UserEventHandlerImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @EventHandler
    public void on(final UserRegisteredEvent event) {
        final User user = User.builder()
                .id(event.getAggregateIdentifier())
                .lastname(event.getLastname())
                .firstname(event.getFirstname())
                .emailAddress(event.getEmailAddress())
                .active(true)
                .build();
        userRepository.save(user);
    }


    @Override
    @EventHandler
    public void on(final UserUpdatedEvent event) {
        final String userId = event.getAggregateIdentifier();
        final User userToUpdate = userRepository.findById(userId).orElse(null);

        if (nonNull(userToUpdate)) {
            Optional.of(event).map(UserUpdatedEvent::getActive).ifPresent(userToUpdate::setActive);
            Optional.of(event).map(UserUpdatedEvent::getLastname).ifPresent(userToUpdate::setLastname);
            Optional.of(event).map(UserUpdatedEvent::getFirstname).ifPresent(userToUpdate::setFirstname);
            userRepository.save(userToUpdate);
        }
    }


    @Override
    @EventHandler
    public void on(final UserRemovedEvent event) {
        final User user = User.builder()
                .id(event.getAggregateIdentifier())
                .build();
        userRepository.delete(user);
    }
}
