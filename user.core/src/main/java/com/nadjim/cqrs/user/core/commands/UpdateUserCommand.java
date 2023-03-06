package com.springbank.user.core.commands;

import com.springbank.user.core.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserCommand extends BaseCommand {
    private final User user;
    public UpdateUserCommand(User user){
        super(user.getId());
        this.user = user;
    }
}
