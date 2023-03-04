package com.springbank.user.query.api.controllers;

import com.springbank.user.core.models.User;
import com.springbank.user.query.api.queries.FindAllUsersQuery;
import com.springbank.user.query.api.queries.FindUserByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserQueryController {
    private final QueryGateway queryGateway;
    public UserQueryController(final QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping()
    public List<User> getAllUsers() {
        final FindAllUsersQuery query = new FindAllUsersQuery();
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(User.class)).join();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") String id) {
        final FindUserByIdQuery query = new FindUserByIdQuery(id);
        final Optional<User> optionalUser = queryGateway.query(query, ResponseTypes.optionalInstanceOf(User.class)).join();
        return ResponseEntity.of(optionalUser);
    }
}
