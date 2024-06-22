package com.automobile.automobileshop.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automobile.automobileshop.Entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    Optional<Brand> findByBrandName(String brandName);

}
