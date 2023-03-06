package com.nadjim.cqrs.user.core.commands;

import com.nadjim.cqrs.core.models.BaseCommand;
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
