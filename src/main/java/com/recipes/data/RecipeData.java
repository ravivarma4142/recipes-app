package com.recipes.data;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "recipes")
public class RecipeData {

	private String recipeName;
	private boolean vegetarian;
	private int serves;
	private String ingredients;
	private String cookingInstructions;
	private Date createdDate; 
}
