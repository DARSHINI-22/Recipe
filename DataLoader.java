package com.example.recipes.config;

import com.example.recipes.model.Recipe;
import com.example.recipes.service.RecipeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final RecipeService service;

    public DataLoader(RecipeService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(
                com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false
        );

        InputStream inputStream =
                getClass().getResourceAsStream("/recipes.json");

        List<Recipe> recipes =
                mapper.readValue(inputStream,
                        new TypeReference<List<Recipe>>() {});

        for (Recipe recipe : recipes) {

            service.saveRecipe(recipe);
        }

        System.out.println("JSON Data Loaded Successfully");
    }
}
