package com.recipes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recipes.data.RecipeData;
import com.recipes.service.RecipesService;

@RestController
public class RecipeController {

	@Autowired
	@Qualifier("recipeDataService")
	private RecipesService recipeService;

	@RequestMapping(method = RequestMethod.POST, value = "/addRecipe")
	public RecipeData addRecipe(@RequestBody RecipeData recipeData) {
		boolean status = recipeService.updateRecipe(recipeData);

		if (status)
			return recipeData;

		return null;
	}

	@RequestMapping("/fetchRecipe/{name}")
	public RecipeData fetchRecipe(@PathVariable String name) {
		return recipeService.fetchRecipe(name);
	}

	
	  @RequestMapping("/allRecipes") 
	public List<RecipeData> allRecipes(@PathVariable(required = false) String name) { 
		  return recipeService.allRecipes();
		  }
	  
}
