package com.nadjim.cqrs.user.core.events;

import com.nadjim.cqrs.core.models.BaseEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRemovedEvent extends BaseEvent {
    private String userId;

    public UserRemovedEvent(final String userId){
        super(userId);
        this.userId = userId;
    }
}
