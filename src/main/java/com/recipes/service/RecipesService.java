package com.recipes.service;

import java.util.List;

import com.recipes.data.RecipeData;

public interface RecipesService {

	public boolean updateRecipe(RecipeData recipeData);

	public RecipeData fetchRecipe(String name);
	
	public List<RecipeData> allRecipes();
	
//	public boolean editRecipe(RecipeData recipeData);
}
