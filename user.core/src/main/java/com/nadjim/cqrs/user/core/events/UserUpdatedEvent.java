package com.nadjim.cqrs.user.core.events;

import com.nadjim.cqrs.core.models.BaseEvent;
import com.nadjim.cqrs.user.core.commands.UpdateUserCommand;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class UserUpdatedEvent extends BaseEvent {
    private final String firstname;
    private final String lastname;
    private final Boolean active;

    public UserUpdatedEvent(final UpdateUserCommand command){
        super(command.getAggregateIdentifier());
        this.firstname = command.getFirstname();
        this.lastname = command.getLastname();
        this.active = command.getActive();
    }
}
