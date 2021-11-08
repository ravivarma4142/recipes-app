package com.recipes.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.recipes.data.RecipeData;
import com.recipes.repository.RecipeDataRepo;
import com.recipes.service.RecipesService;

@Service("recipeDataService")
public class RecipeDataServiceImpl implements RecipesService {

	@Autowired
	private RecipeDataRepo recipeRepo;

	@Override
	public boolean updateRecipe(RecipeData recipeData) {

		try {
		recipeData.setCreatedDate(new Date());
		recipeRepo.save(recipeData);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public RecipeData fetchRecipe(String name) {

		List<RecipeData> recipes = recipeRepo.findAll().stream().filter(recipe -> recipe.getRecipeName() != null)
				.filter(recipe -> recipe.getRecipeName().equals(name)).collect(Collectors.toList());
		if (recipes.size() > 0)
			return recipes.get(0);

		return null;
	}

	@Override
	public List<RecipeData> allRecipes() {
		
		List<RecipeData> recipes = recipeRepo.findAll();
		return recipes;
	}
	
	/*
	 * @Override public boolean editRecipe(RecipeData recipeData) {
	 * 
	 * Query query = new Query();
	 * query.addCriteria(Criteria.where("recipeName").is(recipeData.getRecipeName())
	 * ); //RecipeData previousRecipe = fetchRecipe(recipeData.getRecipeName());
	 * RecipeData previousRecipe = recipeRepo.findOne(query,RecipeData.class);
	 * if(previousRecipe!=null) { previousRecipe.setServes(recipeData.getServes());
	 * previousRecipe.setVegetarian(recipeData.isVegetarian());
	 * previousRecipe.setCookingInstructions(recipeData.getCookingInstructions());
	 * previousRecipe.setIngredients(recipeData.getIngredients());
	 * //recipeRepo.findOne(query,RecipeData.class);
	 * recipeRepo.save(previousRecipe); return true; }
	 * 
	 * return false; }
	 */
}