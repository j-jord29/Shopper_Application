package com.shopperapp.ShopperApp.service;

import com.shopperapp.ShopperApp.persistence.repository.IngredientRepo;
import com.shopperapp.ShopperApp.persistence.domain.Ingredients;
import com.shopperapp.ShopperApp.rest.dto.IngredientDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    //private final List<Ingredients> ingredientsList = new ArrayList<Ingredients>();
    @Autowired
    private final IngredientRepo ingrRepo;
    private final ModelMapper mapper;

    public IngredientService(IngredientRepo ingr_repos, ModelMapper mapper) {
        super();
        this.ingrRepo = ingr_repos;
        this.mapper = mapper;
    }

    private IngredientDTO mapToDTO(Ingredients i) {
        return this.mapper.map(i, IngredientDTO.class);
    }
    public IngredientDTO addIngredientRequest(Ingredients i) {
        Ingredients s = this.ingrRepo.save(i);
        return this.mapToDTO(s);
    }
    public List<IngredientDTO> getAllIngredientsRequest() {
        return this.ingrRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public IngredientDTO updateIngredientRequest(Long ingredient_id, Ingredients new_i) {
        Optional<Ingredients> exOp = Optional.ofNullable(this.ingrRepo.findIngredientByIdJPQL(ingredient_id));
        Ingredients exists = exOp.get();

        exists.setName(new_i.getName());

        Ingredients u = this.ingrRepo.save(exists);
        return this.mapToDTO(u);
    }
    public boolean deleteIngredientRequest(Long ingredient_id) {
        this.ingrRepo.deleteById(ingredient_id);
        boolean doesExist = this.ingrRepo.existsById(ingredient_id);
        return !doesExist;
    }
/*
    public List<IngredientDTO> getIngredientByName(String name) {
        return this.ingrRepo.findIngredientByNameSQL(name);
    }

*/


}
