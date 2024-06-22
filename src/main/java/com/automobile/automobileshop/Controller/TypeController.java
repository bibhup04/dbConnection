package com.automobile.automobileshop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automobile.automobileshop.Entity.VehicleType;
import com.automobile.automobileshop.Service.VehicleTypeService;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @PostMapping("/addMultiple")
    public ResponseEntity<String> addMultipleTypes(@RequestBody List<VehicleType> types) {
        vehicleTypeService.addMultipleTypes(types);
        return new ResponseEntity<>("Vehicle Type added successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleteByName/{typeName}")
    public void deleteTypeByName(@PathVariable String typeName) {
        vehicleTypeService.deleteTypeByName(typeName);
    }

}
