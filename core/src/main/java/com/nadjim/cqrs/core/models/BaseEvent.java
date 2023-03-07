package com.nadjim.cqrs.core.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseEvent {
    private final String aggregateIdentifier;

    public BaseEvent(final String aggregateIdentifier){
        this.aggregateIdentifier = aggregateIdentifier;
    }
}
