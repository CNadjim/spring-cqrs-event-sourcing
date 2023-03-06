package com.nadjim.cqrs.user.command.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreationResponse {
    private String userId;

    public UserCreationResponse(Object userId){
        this.userId = userId.toString();
    }
}
