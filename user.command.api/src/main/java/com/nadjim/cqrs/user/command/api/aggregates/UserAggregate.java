package com.nadjim.cqrs.user.command.api.aggregates;

import com.nadjim.cqrs.user.core.commands.RegisterUserCommand;
import com.nadjim.cqrs.user.core.commands.RemoveUserCommand;
import com.nadjim.cqrs.user.core.commands.UpdateUserCommand;
import com.nadjim.cqrs.user.core.events.UserRegisteredEvent;
import com.nadjim.cqrs.user.core.events.UserRemovedEvent;
import com.nadjim.cqrs.user.core.events.UserUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Optional;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class UserAggregate {
    @AggregateIdentifier
    private String aggregateIdentifier;
    private Boolean active;

    public UserAggregate() {
    }

    @CommandHandler
    public UserAggregate(final RegisterUserCommand command) {
        final UserRegisteredEvent userRegisteredEvent = new UserRegisteredEvent(command);
        apply(userRegisteredEvent);
    }

    @CommandHandler
    public void handle(final UpdateUserCommand command) {
        final UserUpdatedEvent userUpdatedEvent = new UserUpdatedEvent(command);
        apply(userUpdatedEvent);
    }

    @CommandHandler
    public void handle(final RemoveUserCommand command) {
        final UserRemovedEvent event = new UserRemovedEvent(command);
        apply(event);
    }

    @EventSourcingHandler
    public void on(final UserRegisteredEvent event) {
        this.aggregateIdentifier = event.getAggregateIdentifier();
    }

    @EventSourcingHandler
    public void on(final UserUpdatedEvent event) {
        Optional.of(event).map(UserUpdatedEvent::getActive).ifPresent(present -> this.active = present);
    }

    @EventSourcingHandler
    public void on(final UserRemovedEvent event) {
        AggregateLifecycle.markDeleted();
    }
}
