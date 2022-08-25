package com.shopperapp.ShopperApp.rest.dto;

import com.shopperapp.ShopperApp.persistence.domain.ShoppingList;
import com.shopperapp.ShopperApp.persistence.repository.ShoppingListRepo;
import lombok.Getter;
import lombok.Setter;

public class ShoppingListDTO {
    private Long item_id;
    public ShoppingListDTO() {
        super();
    }

    public Long getId() {
        return item_id;
    }

    public void setId(Long new_id){
        this.item_id = new_id;
    }


}


