package com.recipes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.recipes.data.RecipeData;

public interface RecipeDataRepo extends MongoRepository<RecipeData, String>{


}
