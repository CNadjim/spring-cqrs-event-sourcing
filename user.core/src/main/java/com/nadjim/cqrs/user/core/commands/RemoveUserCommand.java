package com.springbank.user.core.commands;

import lombok.*;

@Getter
@Setter
public class RemoveUserCommand extends BaseCommand {
    private final String userId;
    public RemoveUserCommand(String userId) {
        super(userId);
        this.userId = userId;
    }
}
