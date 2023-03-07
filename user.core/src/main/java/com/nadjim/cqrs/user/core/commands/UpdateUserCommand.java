package com.nadjim.cqrs.user.core.commands;

import com.nadjim.cqrs.core.models.BaseCommand;
import com.nadjim.cqrs.user.core.models.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class UpdateUserCommand extends BaseCommand {
    private String firstname;
    private String lastname;
    private Boolean active;
}
