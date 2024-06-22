package com.automobile.automobileshop.DTO;

import lombok.Data;

@Data
public class VehicleDTO {
    private String typeName;
    private String modelName;
    private Double price;
    private Boolean availableForRent;
    private Boolean availableForSale;
    private Long quantity;

}
