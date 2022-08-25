package com.shopperapp.ShopperApp.persistence.repository;

import com.shopperapp.ShopperApp.persistence.domain.ShoppingList;
import com.shopperapp.ShopperApp.rest.dto.ShoppingListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingListRepo extends JpaRepository<ShoppingList, Long> {
    @Query(value = "SELECT * FROM ShoppingLists WHERE ShoppingList_name = ?1", nativeQuery = true)
    List<ShoppingListDTO> findShoppingListByNameSQL(String name);

    @Query(value = "SELECT p FROM ShoppingLists p WHERE p.ShoppingList_id = ?1")
    ShoppingList findShoppingListByIdJPQL(Long id);



}
