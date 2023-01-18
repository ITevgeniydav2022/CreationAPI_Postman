package me.davydovep.recipesapp_3.controller;


import me.davydovep.recipesapp_3.model.Ingredient;
import me.davydovep.recipesapp_3.model.Recipe;
import me.davydovep.recipesapp_3.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public Recipe add(@RequestBody Recipe recipe) {
        return recipeService.add(recipe);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> get(@PathVariable long id) {
        return ResponseEntity.of(recipeService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable long id,
                                             @RequestBody Recipe recipe) {
        return ResponseEntity.of(recipeService.update(id, recipe));
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable long id) {
        return ResponseEntity.of(recipeService.delete(id));
    }

    @GetMapping
    public Map<Long, Recipe> getAll() {
        return recipeService.getAll();
    }
}
