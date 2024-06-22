package com.automobile.automobileshop.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private VehicleType type;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    private String registrationNo;
    private Double price;
    private Boolean availableForSale;
    private Boolean availableForRent;

}
