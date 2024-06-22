package com.automobile.automobileshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automobile.automobileshop.Entity.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

}
