package com.nadjim.cqrs.user.core.events;

import com.nadjim.cqrs.core.models.BaseEvent;
import com.nadjim.cqrs.user.core.commands.RemoveUserCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRemovedEvent extends BaseEvent {

    public UserRemovedEvent(final RemoveUserCommand command){
        super(command.getAggregateIdentifier());
    }
}
