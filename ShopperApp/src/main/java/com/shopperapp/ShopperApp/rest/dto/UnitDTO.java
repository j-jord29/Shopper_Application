package com.shopperapp.ShopperApp.rest.dto;


import com.shopperapp.ShopperApp.exception.IngredientNotFoundException;
import com.shopperapp.ShopperApp.persistence.domain.Ingredients;
import com.shopperapp.ShopperApp.persistence.repository.IngredientRepo;
import lombok.Getter;
import lombok.Setter;

public class UnitDTO {
    private Long unit_id;
    private String unit_name;

    public UnitDTO() {
        super();
        System.out.println("DTO OK");
    }

    public String getName(){
        return unit_name;
    }

    public void setName(String new_name){
        this.unit_name = new_name;
    }

    public Long getId() {
        return unit_id;
    }

    public void setId(Long new_id){
        this.unit_id = new_id;
    }


}


