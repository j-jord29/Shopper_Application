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
public class ShoppingList {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private Ingredients ingredient_id;

    @Column(name = "amount")
    private int amount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    private Units unit_id;

    @OneToMany(mappedBy = "item_id", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)

    private List<ShoppingList> ingredientsList = new ArrayList<>();

    public ShoppingList() {
    }


    public ShoppingList(Long id,String name) {
        this.item_id = id;

    }



    public Long getId() {
        return item_id;
    }

    public void setId(Long new_id){
        this.item_id = new_id;
    }}
