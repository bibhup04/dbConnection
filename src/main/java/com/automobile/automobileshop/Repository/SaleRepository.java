package com.automobile.automobileshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automobile.automobileshop.Entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
