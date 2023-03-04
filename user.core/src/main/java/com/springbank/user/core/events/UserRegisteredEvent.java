package com.springbank.user.core.events;

import com.springbank.user.core.models.BaseEvent;
import com.springbank.user.core.models.User;
import lombok.*;


@Getter
@Setter
public class UserRegisteredEvent extends BaseEvent {
    private User user;

    public UserRegisteredEvent(User user){
        super(user.getId());
        this.user = user;
    }
}
