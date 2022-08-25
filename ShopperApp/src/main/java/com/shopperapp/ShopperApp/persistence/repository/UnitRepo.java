package com.shopperapp.ShopperApp.persistence.repository;

import com.shopperapp.ShopperApp.persistence.domain.Units;
import com.shopperapp.ShopperApp.rest.dto.UnitDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepo extends JpaRepository<Units, Long> {
    @Query(value = "SELECT * FROM Units WHERE unit_name = ?1", nativeQuery = true)
    List<UnitDTO> findUnitByNameSQL(String name);

    @Query(value = "SELECT p FROM Units p WHERE p.unit_id = ?1")
    Units findUnitByIdJPQL(Long id);



}
