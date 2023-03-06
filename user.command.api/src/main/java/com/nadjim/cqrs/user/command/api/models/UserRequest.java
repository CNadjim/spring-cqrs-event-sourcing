package com.nadjim.cqrs.user.command.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = "Firstname is mandatory.")
    private String firstname;
    @NotBlank(message = "Lastname is mandatory.")
    private String lastname;
    @Email(message = "Please provide a valid email address.")
    private String emailAddress;
}
