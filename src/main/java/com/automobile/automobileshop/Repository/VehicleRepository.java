package com.automobile.automobileshop.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automobile.automobileshop.Entity.Model;
import com.automobile.automobileshop.Entity.Vehicle;
import com.automobile.automobileshop.Entity.VehicleType;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findTopByModelAndTypeOrderByRegistrationNoDesc(Model model, VehicleType type);

}
