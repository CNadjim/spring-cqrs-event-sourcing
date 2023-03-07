package com.nadjim.cqrs.user.core.events;

import com.nadjim.cqrs.core.models.BaseEvent;
import com.nadjim.cqrs.user.core.commands.RegisterUserCommand;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRegisteredEvent extends BaseEvent {
    private final String firstname;
    private final String lastname;
    private final String emailAddress;

    public UserRegisteredEvent(final RegisterUserCommand command){
        super(command.getAggregateIdentifier());
        this.firstname = command.getFirstname();
        this.lastname = command.getLastname();
        this.emailAddress = command.getEmailAddress();
    }
}
