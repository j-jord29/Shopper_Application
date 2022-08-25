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
public class Units {
    @Id
    @Column(name = "unit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unit_id;
    @Column(name = "unit_name")
    private String name;

    @OneToMany(mappedBy = "unit_id", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Units> unitList = new ArrayList<>();

    public Units() {
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
        return unit_id;
    }

    public void setId(Long new_id){
        this.unit_id = new_id;
    }

    public void getString() {
        System.out.println(getId() + " " + getName());
    }




}
