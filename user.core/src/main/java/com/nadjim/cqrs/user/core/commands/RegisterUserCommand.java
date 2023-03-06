package com.nadjim.cqrs.user.core.commands;

import com.nadjim.cqrs.core.models.BaseCommand;
import com.nadjim.cqrs.user.core.models.User;
import lombok.*;

@Getter
@Setter
public class RegisterUserCommand extends BaseCommand {
    private final User user;
    public RegisterUserCommand(User user){
        super(user.getId());
        this.user = user;
    }
}
