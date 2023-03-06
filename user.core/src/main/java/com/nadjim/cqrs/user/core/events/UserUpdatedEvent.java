package com.nadjim.cqrs.user.core.events;

import com.nadjim.cqrs.core.models.BaseEvent;
import com.nadjim.cqrs.user.core.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdatedEvent extends BaseEvent {
    private User user;

    public UserUpdatedEvent(final User user){
        super(user.getId());
        this.user = user;
    }
}
