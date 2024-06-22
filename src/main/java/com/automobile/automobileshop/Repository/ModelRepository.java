package com.automobile.automobileshop.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automobile.automobileshop.Entity.Model;
import com.automobile.automobileshop.Entity.VehicleType;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    Optional<Model> findByModelName(String modelName);

}
