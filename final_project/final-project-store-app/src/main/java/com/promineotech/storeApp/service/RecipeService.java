package com.promineotech.storeApp.service;


import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.storeApp.entity.Recipe;
import com.promineotech.storeApp.repostitory.RecipeRepository;



@Service
public class RecipeService {

	private static final Logger logger = LogManager.getLogger(RecipeService.class);
	
	@Autowired
	private RecipeRepository repo;
	
	public Iterable<Recipe> getRecipe() {
		return repo.findAll();
	}
	
	public Recipe createRecipe(Recipe recipe) {
		
		
		
		return repo.save(recipe);
	}
	
	public Recipe updateRecipe(Recipe recipe, Long id) {
		logger.info("Updating recipe {}" + recipe);
		Recipe oldRecipe = repo.findById(id)
					.orElseThrow(() -> new NoSuchElementException("Can't find recipe with id:" + id));
			oldRecipe.setName(recipe.getName());
			oldRecipe.setFlavors(flavors);
			return repo.save(oldRecipe);
		
	}
	
	public void removeRecipe(Long id) throws Exception {
		try {
			repo.deleteById(id);			
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete product: " + id, e);
			throw new Exception("Unable to delete product.");
		}
	}
		

}
