package com.nadjim.cqrs.user.command.api.aggregates;

import com.nadjim.cqrs.user.core.commands.RegisterUserCommand;
import com.nadjim.cqrs.user.core.commands.RemoveUserCommand;
import com.nadjim.cqrs.user.core.commands.UpdateUserCommand;
import com.nadjim.cqrs.user.core.events.UserRegisteredEvent;
import com.nadjim.cqrs.user.core.events.UserRemovedEvent;
import com.nadjim.cqrs.user.core.events.UserUpdatedEvent;
import com.nadjim.cqrs.user.core.models.User;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class UserAggregate {
    @AggregateIdentifier
    private String id;
    private User user;

    public UserAggregate() {

    }

    @CommandHandler
    public UserAggregate(final RegisterUserCommand command) {
        final User commandUser = command.getUser();
        final UserRegisteredEvent userRegisteredEvent = new UserRegisteredEvent(commandUser);
        this.user = commandUser;
        apply(userRegisteredEvent);
    }

    @CommandHandler
    public void handle(final UpdateUserCommand command) {
        final User commandUser = command.getUser();
        final UserUpdatedEvent userUpdatedEvent = new UserUpdatedEvent(commandUser);
        this.user = commandUser;
        apply(userUpdatedEvent);
    }

    @CommandHandler
    public void handle(final RemoveUserCommand command) {
        final String userId = command.getUserId();
        final UserRemovedEvent event = new UserRemovedEvent(userId);
        apply(event);
    }

    @EventSourcingHandler
    public void on(final UserRegisteredEvent event) {
        this.id = event.getId();
        this.user = event.getUser();
    }

    @EventSourcingHandler
    public void on(final UserUpdatedEvent event) {
        this.user = event.getUser();
    }

    @EventSourcingHandler
    public void on(final UserRemovedEvent event) {
        this.user = null;
        AggregateLifecycle.markDeleted();
    }
}