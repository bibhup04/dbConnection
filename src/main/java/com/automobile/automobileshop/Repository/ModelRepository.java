package com.automobile.automobileshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automobile.automobileshop.Entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

}
