package com.springbank.user.query.api.handlers;

import com.springbank.user.core.models.User;
import com.springbank.user.query.api.queries.FindAllUsersQuery;
import com.springbank.user.query.api.queries.FindUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryHandler {

    List<User> findAll(FindAllUsersQuery query);
    Optional<User> findById(FindUserByIdQuery query);
}
