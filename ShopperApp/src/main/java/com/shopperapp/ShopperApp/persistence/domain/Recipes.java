package com.shopperapp.ShopperApp.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
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
    @Column(name = "recipe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipe_id;
    @Column(name = "recipe_name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_idFK", referencedColumnName = "unit_id")
    private List<Ingredients> ingredient_id;

    @Column(name = "amount")
    private int amount;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_idFK", referencedColumnName = "unit_id")
    private List<Units> unit_id;

    @OneToMany(mappedBy = "recipe_id", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Recipes> recipesList = new ArrayList<>();

    public Recipes() {
        super();
    }

    public Recipes(Long id,String name) {
        super();
        this.recipe_id = id;
        this.name = name;
    }

/*

    public String getName(){
        return name;
    }

    public void setName(String new_name){
        this.name = new_name;
    }

    public Long getId() {
        return recipe_id;
    }

    public void setId(Long new_id){
        this.recipe_id = new_id;
    }

    public void getString() {
        System.out.println(getId() + " " + getName());
    }

 */

}
