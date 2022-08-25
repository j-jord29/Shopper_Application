package com.shopperapp.ShopperApp.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Ingredients {
    @Id
    @Column(name = "ingredient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredient_id;
    @Column(name = "ingredient_name")
    private String name;

    @OneToMany(mappedBy = "ingredient_id", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Ingredients> ingredientsList = new ArrayList<>();

    public Ingredients() {
    }

    /*

    public Ingredients(Long id,String name) {
        this.ingredient_id = id;
        this.name = name;
    }

    */

    public String getName(){
        return name;
    }
    public void setName(String new_name){
        this.name = new_name;
    }

    public Long getId() {
        return ingredient_id;
    }

    public void setId(Long new_id){
        this.ingredient_id = new_id;
    }

    public void getString() {
        System.out.println(getId() + " " + getName());
    }




}
