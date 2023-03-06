package com.nadjim.cqrs.user.core.events;

import com.nadjim.cqrs.core.models.BaseEvent;
import com.nadjim.cqrs.user.core.models.User;
import lombok.*;


@Getter
@Setter
public class UserRegisteredEvent extends BaseEvent {
    private User user;

    public UserRegisteredEvent(final User user){
        super(user.getId());
        this.user = user;
    }
}
