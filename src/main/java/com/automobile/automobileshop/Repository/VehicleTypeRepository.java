package com.automobile.automobileshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automobile.automobileshop.Entity.VehicleType;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
    void deleteByTypeName(String typeName);

    VehicleType findByTypeName(String typeName);

}
