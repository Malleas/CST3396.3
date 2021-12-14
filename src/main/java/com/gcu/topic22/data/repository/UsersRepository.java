package com.gcu.topic22.data.repository;

import com.gcu.topic22.data.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<UserEntity, String> {

    UserEntity findByUsername(String username);
}
