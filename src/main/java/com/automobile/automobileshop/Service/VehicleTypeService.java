package com.automobile.automobileshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automobile.automobileshop.Entity.VehicleType;
import com.automobile.automobileshop.Repository.VehicleTypeRepository;

import jakarta.transaction.Transactional;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> getAllVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    public VehicleType getVehicleTypeById(Long id) {
        return vehicleTypeRepository.findById(id).orElse(null);
    }

    public void saveOrUpdateVehicleType(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    public void deleteVehicleType(Long id) {
        vehicleTypeRepository.deleteById(id);
    }

    public void deleteTypeByName(String typeName) {
        vehicleTypeRepository.deleteByTypeName(typeName);
    }

    @Transactional
    public void addMultipleTypes(List<VehicleType> types) {
        vehicleTypeRepository.saveAll(types);
    }

    public VehicleType getVehicleTypeByTypeName(String typeName) {
        return vehicleTypeRepository.findByTypeName(typeName)
                .orElseThrow(() -> new RuntimeException("VehicleType not found with typeName: " + typeName));
    }

}
