package com.nadjim.cqrs.user.core.commands;

import com.nadjim.cqrs.core.models.BaseCommand;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class RemoveUserCommand extends BaseCommand {
}
