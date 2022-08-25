package com.shopperapp.ShopperApp.service;

import com.shopperapp.ShopperApp.persistence.repository.RecipeRepo;
import com.shopperapp.ShopperApp.persistence.domain.Recipes;
import com.shopperapp.ShopperApp.rest.dto.RecipeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    //private final List<Recipes> RecipesList = new ArrayList<Recipes>();
    @Autowired
    private final RecipeRepo recpRepo;
    private final ModelMapper mapper;

    public RecipeService(RecipeRepo recp_repos, ModelMapper mapper) {
        super();
        this.recpRepo = recp_repos;
        this.mapper = mapper;
    }

    private RecipeDTO mapToDTO(Recipes i) {
        return this.mapper.map(i, RecipeDTO.class);
    }
    public RecipeDTO addRecipeRequest(Recipes i) {
        Recipes s = this.recpRepo.save(i);
        return this.mapToDTO(s);
    }
    public List<RecipeDTO> getAllRecipesRequest() {
        return this.recpRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public RecipeDTO updateRecipeRequest(Long recipe_id, Recipes new_i) {
        Optional<Recipes> exOp = Optional.ofNullable(this.recpRepo.findRecipeByIdJPQL(recipe_id));
        Recipes exists = exOp.get();
        exists.setName(new_i.getName());

        Recipes u = this.recpRepo.save(exists);
        System.out.println("Service OK");
        return this.mapToDTO(u);
    }
    public boolean deleteRecipeRequest(Long recipe_id) {
        this.recpRepo.deleteById(recipe_id);
        boolean doesExist = this.recpRepo.existsById(recipe_id);
        return !doesExist;
    }
/*
    public List<RecipeDTO> getRecipeByName(String name) {
        return this.recpRepo.findRecipeByNameSQL(name);
    }

*/


}
