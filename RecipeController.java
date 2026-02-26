package com.example.recipes.controller;

import com.example.recipes.model.Recipe;
import com.example.recipes.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    // ✅ GET Top Recipes
    @GetMapping("/top")
    public Map<String, List<Recipe>> getTopRecipes(
            @RequestParam(defaultValue = "5") int limit) {

        List<Recipe> list = service.getTopRecipes(limit);
        return Map.of("data", list);
    }

    // ✅ POST New Recipe
    @PostMapping
    public Recipe addRecipe(@Valid @RequestBody Recipe recipe) {
        return service.saveRecipe(recipe);
    }
}