package com.shopperapp.ShopperApp.persistence.repository;

import com.shopperapp.ShopperApp.persistence.domain.Ingredients;
import com.shopperapp.ShopperApp.rest.dto.IngredientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredients, Long> {
    @Query(value = "SELECT * FROM Ingredients WHERE ingredient_name = ?1", nativeQuery = true)
    List<IngredientDTO> findIngredientByNameSQL(String name);

    @Query(value = "SELECT p FROM Ingredients p WHERE p.ingredient_id = ?1")
    Ingredients findIngredientByIdJPQL(Long id);



}
