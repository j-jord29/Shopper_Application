package com.shopperapp.ShopperApp.rest.controller;

import com.shopperapp.ShopperApp.rest.dto.UnitDTO;
import com.shopperapp.ShopperApp.service.UnitService;
import com.shopperapp.ShopperApp.persistence.domain.Units;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UnitController {
    private UnitService UNITSERVICE;

    @Autowired
    public UnitController(UnitService us) {
        super();
        this.UNITSERVICE = us;
    }

    @PostMapping("/createUnit")
    public UnitDTO postMapUnits(@RequestBody Units i) {
        return this.UNITSERVICE.addUnitRequest(i);
    }

    @GetMapping("/getUnit")
    public List<UnitDTO> getMapUnits() {
        return UNITSERVICE.getAllUnitsRequest();
    }

    @PutMapping("/updateUnit")
    public UnitDTO updateUnit(@PathParam("Unit_id") Long Unit_id, @RequestBody Units i) {
        return this.UNITSERVICE.updateUnitRequest(Unit_id, i);
    }

    @DeleteMapping("/deleteUnit/{Unit_id}")
    public boolean deleteUnit(@PathVariable Long Unit_id) {
        return this.UNITSERVICE.deleteUnitRequest(Unit_id);
    }
/*
    @GetMapping("/getUnitByName")
    public List<UnitDTO> getUnitByName(String name) {
        return this.UnitSERVICE.getUnitByName(name);
    }
*/
}

