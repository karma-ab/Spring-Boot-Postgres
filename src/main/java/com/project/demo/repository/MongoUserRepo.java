package com.project.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.mongoEntity.UserEntity;

@Repository
public interface MongoUserRepo extends MongoRepository<UserEntity, String> {
}