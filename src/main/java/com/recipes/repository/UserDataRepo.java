package com.recipes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.recipes.data.UserData;

public interface UserDataRepo extends MongoRepository<UserData, String>{

}
