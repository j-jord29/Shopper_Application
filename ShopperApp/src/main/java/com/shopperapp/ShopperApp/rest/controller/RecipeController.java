package com.shopperapp.ShopperApp.rest.controller;

import com.shopperapp.ShopperApp.rest.dto.RecipeDTO;
import com.shopperapp.ShopperApp.service.RecipeService;
import com.shopperapp.ShopperApp.persistence.domain.Recipes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class RecipeController {
    private RecipeService RECIPESERVICE;

    @Autowired
    public RecipeController(RecipeService is) {
        super();
        this.RECIPESERVICE = is;
    }

    @PostMapping("/createRecipe")
    public RecipeDTO postMapRecipes(@RequestBody Recipes i) {
        return this.RECIPESERVICE.addRecipeRequest(i);
    }

    @GetMapping("/getRecipe")
    public List<RecipeDTO> getMapRecipes() {
        return RECIPESERVICE.getAllRecipesRequest();
    }

    @PutMapping("/updateRecipe")
    public RecipeDTO updateRecipe(@PathParam("Recipe_id") Long recipe_id, @RequestBody Recipes i) {
        return this.RECIPESERVICE.updateRecipeRequest(recipe_id, i);
    }

    @DeleteMapping("/deleteRecipe/{Recipe_id}")
    public boolean deleteRecipe(@PathVariable Long recipe_id) {
        return this.RECIPESERVICE.deleteRecipeRequest(recipe_id);
    }
/*
    @GetMapping("/getRecipeByName")
    public List<RecipeDTO> getRecipeByName(String name) {
        return this.RecipeSERVICE.getRecipeByName(name);
    }
*/
}

