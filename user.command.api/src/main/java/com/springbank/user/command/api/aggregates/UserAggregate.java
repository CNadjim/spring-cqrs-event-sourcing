package com.springbank.user.command.api.aggregates;

import com.springbank.user.command.api.commands.RegisterUserCommand;
import com.springbank.user.command.api.commands.RemoveUserCommand;
import com.springbank.user.command.api.commands.UpdateUserCommand;
import com.springbank.user.core.events.UserRegisteredEvent;
import com.springbank.user.core.events.UserRemovedEvent;
import com.springbank.user.core.events.UserUpdatedEvent;
import com.springbank.user.core.models.User;
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
