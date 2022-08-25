package com.shopperapp.ShopperApp.service;

import com.shopperapp.ShopperApp.persistence.repository.UnitRepo;
import com.shopperapp.ShopperApp.persistence.domain.Units;
import com.shopperapp.ShopperApp.rest.dto.UnitDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnitService {

    //private final List<Units> UnitsList = new ArrayList<Units>();
    @Autowired
    private final UnitRepo unitRepo;
    private final ModelMapper mapper;

    public UnitService(UnitRepo unit_repos, ModelMapper mapper) {
        super();
        this.unitRepo = unit_repos;
        this.mapper = mapper;
    }

    private UnitDTO mapToDTO(Units i) {
        return this.mapper.map(i, UnitDTO.class);
    }
    public UnitDTO addUnitRequest(Units i) {
        Units s = this.unitRepo.save(i);
        return this.mapToDTO(s);
    }
    public List<UnitDTO> getAllUnitsRequest() {
        return this.unitRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public UnitDTO updateUnitRequest(Long Unit_id, Units new_i) {
        Optional<Units> exOp = Optional.ofNullable(this.unitRepo.findUnitByIdJPQL(Unit_id));
        Units exists = exOp.get();
        exists.setName(new_i.getName());

        Units u = this.unitRepo.save(exists);
        return this.mapToDTO(u);
    }
    public boolean deleteUnitRequest(Long Unit_id) {
        this.unitRepo.deleteById(Unit_id);
        boolean doesExist = this.unitRepo.existsById(Unit_id);
        return !doesExist;
    }
/*
    public List<UnitDTO> getUnitByName(String name) {
        return this.unitRepo.findUnitByNameSQL(name);
    }

*/


}
