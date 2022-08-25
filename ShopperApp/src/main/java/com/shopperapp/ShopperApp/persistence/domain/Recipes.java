package com.shopperapp.ShopperApp.persistence.domain;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Data
@Table(name = "recipes")
public class Recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipe_id;
    @Column(name = "recipe_name")
    private String recipe_name;

    @Column
    private Long ingredient_id;

    @Column
    private int amount;
    @Column
    private Long unit_id;

    @OneToMany(mappedBy = "recipe_id", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Recipes> recipesList = new ArrayList<>();

    /*

    public Recipes(Long recipe_id, String recipe_name, Long ingredient_id, int amount, Long unit_id) {
        super();
        this.recipe_id = recipe_id;
        this.recipe_name = recipe_name;
        this.ingredient_id = ingredient_id;
        this.amount = amount;
        this.unit_id = unit_id;
    }

     */

    public Recipes() {
        super();

    }

    public Long getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Long recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
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
