package com.springbank.user.core.events;

import com.springbank.user.core.models.BaseEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRemovedEvent extends BaseEvent {
    private String userId;

    public UserRemovedEvent(String userId){
        super(userId);
        this.userId = userId;
    }
}
