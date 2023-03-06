package com.springbank.user.query.api.handlers.impl;

import com.nadjim.cqrs.user.core.models.User;
import com.springbank.user.query.api.handlers.UserQueryHandler;
import com.springbank.user.query.api.queries.FindAllUsersQuery;
import com.springbank.user.query.api.queries.FindUserByIdQuery;
import com.springbank.user.query.api.repositories.UserRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryHandlerImpl implements UserQueryHandler {
    private final UserRepository userRepository;
    public UserQueryHandlerImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @QueryHandler
    public Optional<User> findById(final FindUserByIdQuery query) {
        return userRepository.findById(query.getId());
    }

    @Override
    @QueryHandler
    public List<User> findAll(final FindAllUsersQuery query) {
        return userRepository.findAll();
    }
}
