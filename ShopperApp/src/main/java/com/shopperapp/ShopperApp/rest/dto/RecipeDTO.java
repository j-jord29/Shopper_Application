package com.shopperapp.ShopperApp.rest.dto;

import com.shopperapp.ShopperApp.exception.IngredientNotFoundException;
import com.shopperapp.ShopperApp.persistence.domain.Ingredients;
import com.shopperapp.ShopperApp.persistence.repository.IngredientRepo;
import lombok.Getter;
import lombok.Setter;

public class RecipeDTO {
    private Long recipe_id;
    private String recipe_name;

    public RecipeDTO() {
        super();
        System.out.println("DTO OK");
    }

    public String getName(){
        return recipe_name;
    }

    public void setName(String new_name){
        this.recipe_name = new_name;
    }

    public Long getId() {
        return recipe_id;
    }

    public void setId(Long new_id){
        this.recipe_id = new_id;
    }


}


