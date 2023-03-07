package com.nadjim.cqrs.user.command.api.models;

import com.nadjim.cqrs.core.validators.NullOrNotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {
    @NullOrNotBlank
    private String firstname;
    @NullOrNotBlank
    private String lastname;
    private Boolean active;
}
