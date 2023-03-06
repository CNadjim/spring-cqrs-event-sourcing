package com.springbank.user.query.api.handlers;

import com.nadjim.cqrs.user.core.events.UserRegisteredEvent;
import com.nadjim.cqrs.user.core.events.UserRemovedEvent;
import com.nadjim.cqrs.user.core.events.UserUpdatedEvent;

public interface UserEventHandler {
    void on(UserRegisteredEvent event);
    void on(UserUpdatedEvent event);
    void on(UserRemovedEvent event);
}
