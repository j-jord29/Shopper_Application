package com.shopperapp.ShopperApp.service;

import com.shopperapp.ShopperApp.persistence.domain.ShoppingList;
import com.shopperapp.ShopperApp.persistence.repository.ShoppingListRepo;
import com.shopperapp.ShopperApp.rest.dto.ShoppingListDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingListService {

    //private final List<ShoppingList> ShoppingListList = new ArrayList<ShoppingList>();
    @Autowired
    private final ShoppingListRepo shopRepo;
    private final ModelMapper mapper;

    public ShoppingListService(ShoppingListRepo shop_repos, ModelMapper mapper) {
        super();
        this.shopRepo = shop_repos;
        this.mapper = mapper;
    }

    private ShoppingListDTO mapToDTO(ShoppingList i) {
        return this.mapper.map(i, ShoppingListDTO.class);
    }
    public ShoppingListDTO addShoppingListRequest(ShoppingList i) {
        ShoppingList s = this.shopRepo.save(i);
        return this.mapToDTO(s);
    }
    public List<ShoppingListDTO> getAllShoppingListRequest() {
        return this.shopRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public ShoppingListDTO updateShoppingListRequest(Long ShoppingList_id, ShoppingList new_i) {
        Optional<ShoppingList> exOp = Optional.ofNullable(this.shopRepo.findShoppingListByIdJPQL(ShoppingList_id));
        ShoppingList exists = exOp.get();

        ShoppingList u = this.shopRepo.save(exists);
        System.out.println("Service OK");
        return this.mapToDTO(u);
    }
    public boolean deleteShoppingListRequest(Long ShoppingList_id) {
        this.shopRepo.deleteById(ShoppingList_id);
        boolean doesExist = this.shopRepo.existsById(ShoppingList_id);
        return !doesExist;
    }
/*
    public List<ShoppingListDTO> getShoppingListByName(String name) {
        return this.shopRepo.findShoppingListByNameSQL(name);
    }

*/


}
