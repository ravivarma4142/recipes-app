package com.recipes.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipes.data.RecipeData;
import com.recipes.repository.RecipeDataRepo;
import com.recipes.serviceImpl.RecipeDataServiceImpl;
import com.recipes.test.RecipesAppTest;

public class RecipeDataTest extends RecipesAppTest{
	
	@InjectMocks
	@Autowired
	RecipeDataServiceImpl recipeService;
	
	@Autowired
	RecipeDataRepo recipeRepo;
	
	@Test
    public void updateRecipeTest() throws Exception{
        String recipe = "{\r\n"
        		+ "\"recipeName\":\"Pasta\",\r\n"
        		+ "\"vegetarian\":false,\r\n"
        		+ "\"serves\":2,\r\n"
        		+ "\"ingredients\":\"flour,corn,rice, quinoa,Olive,cream\",\r\n"
        		+ "\"cookingInstructions\":\"simmer with all ingredients\"\r\n"
        		+ "}";
        RecipeData recipes= new ObjectMapper().readValue(recipe, RecipeData.class);
        boolean stats = recipeService.updateRecipe(recipes);
        Assert.assertEquals(true, stats);

    }
	
		@Test
	    public void fecthRecipeTest() {
	        RecipeData recipe = recipeService.fetchRecipe("Pasta");
	        Assert.assertTrue("Pasta".equals(recipe.getRecipeName()));
	    }
}
