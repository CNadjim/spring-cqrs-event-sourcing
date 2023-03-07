package com.nadjim.cqrs.core.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@SuperBuilder
public abstract class BaseCommand {
    @TargetAggregateIdentifier
    private final String aggregateIdentifier;

}