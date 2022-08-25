package com.shopperapp.ShopperApp.rest.controller;

import com.shopperapp.ShopperApp.rest.dto.IngredientDTO;
import com.shopperapp.ShopperApp.service.IngredientService;
import com.shopperapp.ShopperApp.persistence.domain.Ingredients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class IngredientController {
    private IngredientService INGREDIENTSERVICE;

    @Autowired
    public IngredientController(IngredientService is) {
        super();
        this.INGREDIENTSERVICE = is;
    }

    @PostMapping("/createIngredient")
    public IngredientDTO postMapIngredients(@RequestBody Ingredients i) {
        return this.INGREDIENTSERVICE.addIngredientRequest(i);
    }

    @GetMapping("/getIngredient")
    public List<IngredientDTO> getMapIngredients() {
        return INGREDIENTSERVICE.getAllIngredientsRequest();
    }

    @PutMapping("/updateIngredient")
    public IngredientDTO updateIngredient(@PathParam("ingredient_id") Long ingredient_id, @RequestBody Ingredients i) {
        return this.INGREDIENTSERVICE.updateIngredientRequest(ingredient_id, i);
    }

    @DeleteMapping("/deleteIngredient/{ingredient_id}")
    public boolean deleteIngredient(@PathVariable Long ingredient_id) {
        return this.INGREDIENTSERVICE.deleteIngredientRequest(ingredient_id);
    }
/*
    @GetMapping("/getIngredientByName")
    public List<IngredientDTO> getIngredientByName(String name) {
        return this.INGREDIENTSERVICE.getIngredientByName(name);
    }
*/
}

