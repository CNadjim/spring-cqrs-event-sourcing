package com.springbank.user.core.events;

import com.springbank.user.core.models.BaseEvent;
import com.springbank.user.core.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdatedEvent extends BaseEvent {
    private User user;

    public UserUpdatedEvent(User user){
        super(user.getId());
        this.user = user;
    }
}
