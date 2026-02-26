package com.example.recipes.service;

import com.example.recipes.model.Recipe;
import com.example.recipes.repository.RecipeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    // POST logic
    public Recipe saveRecipe(Recipe recipe) {

        if (recipe == null) {
            return null;
        }

        Integer prep = recipe.getPrepTime();
        Integer cook = recipe.getCookTime();

        if (prep != null && cook != null) {
            recipe.setTotalTime(prep + cook);
        } else if (recipe.getTotalTime() == null) {
            recipe.setTotalTime(0);
        }

        return repository.save(recipe);
    }

    // GET TOP logic
    public List<Recipe> getTopRecipes(int limit) {
        return repository.findAll()
                .stream()
                .sorted((r1, r2) ->
                        Double.compare(
                                r2.getRating() == null ? 0 : r2.getRating(),
                                r1.getRating() == null ? 0 : r1.getRating()
                        )
                )
                .limit(limit)
                .toList();
    }
}

