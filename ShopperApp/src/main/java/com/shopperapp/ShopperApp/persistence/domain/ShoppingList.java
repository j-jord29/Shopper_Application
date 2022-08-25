package com.shopperapp.ShopperApp.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ShoppingList {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;


    @Column(name = "ingredient_id")
    private Long ingredient_id;

    @Column(name = "amount")
    private int amount;

    @Column(name = "unit_id")
    private Long unit_id;

    @OneToMany(mappedBy = "item_id", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)

    private List<ShoppingList> ingredientsList = new ArrayList<>();

    /*

    public ShoppingList(Long item_id,Long ingredient_id,int amount,Long unit_id) {
        this.item_id = item_id;
        this.ingredient_id = ingredient_id;
        this.amount = amount;
        this.unit_id = unit_id;
    }

     */

    public ShoppingList() {
        super();

    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(Long unit_id) {
        this.unit_id = unit_id;
    }
}