package com.springbank.user.command.api.commands;

import com.springbank.user.core.models.User;
import com.springbank.user.core.models.BaseCommand;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class RegisterUserCommand extends BaseCommand {
    private final User user;
    public RegisterUserCommand(User user){
        super(user.getId());
        this.user = user;
    }
}
