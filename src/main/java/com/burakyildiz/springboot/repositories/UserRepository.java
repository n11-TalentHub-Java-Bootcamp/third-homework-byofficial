package com.burakyildiz.springboot.repositories;

import com.burakyildiz.springboot.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
