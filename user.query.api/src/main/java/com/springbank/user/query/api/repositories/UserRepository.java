package com.springbank.user.query.api.repositories;

import com.nadjim.cqrs.user.core.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
