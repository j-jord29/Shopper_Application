package com.shopperapp.ShopperApp.rest.controller;

import com.shopperapp.ShopperApp.rest.dto.ShoppingListDTO;
import com.shopperapp.ShopperApp.service.ShoppingListService;
import com.shopperapp.ShopperApp.persistence.domain.ShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ShoppingListController {
    private ShoppingListService SHOPPINGLISTSERVICE;

    @Autowired
    public ShoppingListController(ShoppingListService is) {
        super();
        this.SHOPPINGLISTSERVICE = is;
    }

    @PostMapping("/createItemInShoppingList")
    public ShoppingListDTO postMapShoppingLists(@RequestBody ShoppingList i) {
        return this.SHOPPINGLISTSERVICE.addShoppingListRequest(i);
    }

    @GetMapping("/getShoppingList")
    public List<ShoppingListDTO> getMapShoppingLists() {
        return SHOPPINGLISTSERVICE.getAllShoppingListRequest();
    }

    @PutMapping("/updateShoppingList")
    public ShoppingListDTO updateShoppingList(@PathParam("ShoppingList_id") Long ShoppingList_id, @RequestBody ShoppingList i) {
        return this.SHOPPINGLISTSERVICE.updateShoppingListRequest(ShoppingList_id, i);
    }

    @DeleteMapping("/deleteItemInShoppingList/{ShoppingList_id}")
    public boolean deleteShoppingList(@PathVariable Long ShoppingList_id) {
        return this.SHOPPINGLISTSERVICE.deleteShoppingListRequest(ShoppingList_id);
    }
/*
    @GetMapping("/getShoppingListByName")
    public List<ShoppingListDTO> getShoppingListByName(String name) {
        return this.ShoppingListSERVICE.getShoppingListByName(name);
    }
*/
}

