package com.springbank.user.command.api.commands;

import com.springbank.user.core.models.BaseCommand;
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
