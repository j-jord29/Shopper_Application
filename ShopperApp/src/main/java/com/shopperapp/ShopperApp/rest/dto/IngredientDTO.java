package com.shopperapp.ShopperApp.rest.dto;


import com.shopperapp.ShopperApp.exception.IngredientNotFoundException;
import com.shopperapp.ShopperApp.persistence.domain.Ingredients;
import com.shopperapp.ShopperApp.persistence.repository.IngredientRepo;
import lombok.Getter;
import lombok.Setter;

public class IngredientDTO {
    private Long ingredient_id;
    private String ingredient_name;

    public IngredientDTO() {
        super();
    }

    public String getName(){
        return ingredient_name;
    }

    public void setName(String new_name){
        this.ingredient_name = new_name;
    }

    public Long getId() {
        return ingredient_id;
    }

    public void setId(Long new_id){
        this.ingredient_id = new_id;
    }


}


