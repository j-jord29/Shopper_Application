package com.shopperapp.ShopperApp.persistence.repository;

import com.shopperapp.ShopperApp.persistence.domain.Recipes;
import com.shopperapp.ShopperApp.rest.dto.RecipeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepo extends JpaRepository<Recipes, Long> {
    @Query(value = "SELECT p FROM Recipes p WHERE p.Recipe_id = ?1")
    Recipes findRecipeByIdJPQL(Long id);



}
