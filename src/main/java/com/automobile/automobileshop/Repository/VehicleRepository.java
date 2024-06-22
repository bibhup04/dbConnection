package com.automobile.automobileshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automobile.automobileshop.Entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
