package com.automobile.automobileshop.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automobile.automobileshop.DTO.VehicleDTO;
import com.automobile.automobileshop.Entity.Model;
import com.automobile.automobileshop.Entity.Vehicle;
import com.automobile.automobileshop.Entity.VehicleType;
import com.automobile.automobileshop.Repository.VehicleRepository;

import jakarta.transaction.Transactional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @Autowired
    private ModelService modelService;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public void saveOrUpdateVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Transactional
    public void saveVehicle(VehicleDTO vehicleDTO) {

        VehicleType vehicleType = vehicleTypeService.getVehicleTypeByTypeName(vehicleDTO.getTypeName());
        Model model = modelService.getModelTypeByModelName(vehicleDTO.getModelName());

        String redgNo = generateRedgNo(vehicleType, model);
        for (int i = 0; i < vehicleDTO.getQuantity(); i++) {
            Vehicle vehicle = new Vehicle();

            vehicle.setPrice(vehicleDTO.getPrice());
            vehicle.setType(vehicleType);
            vehicle.setModel(model);
            vehicle.setAvailableForRent(vehicleDTO.getAvailableForRent());
            vehicle.setAvailableForSale(vehicleDTO.getAvailableForSale());
            redgNo = incrementRegestrationNo(redgNo);
            System.out.print(" redg no is - " + redgNo);
            vehicle.setRegistrationNo(redgNo);

            vehicleRepository.save(vehicle);
        }
    }

    public String generateRedgNo(VehicleType type, Model model) {
        String year = String.valueOf(Year.now().getValue()).substring(2);
        String modelCode = model.getModelName().substring(0, 3).toUpperCase();
        String typeCode = type.getTypeName().substring(0, 3).toUpperCase();

        // Fetch the last vehicle entry for the same model and type
        Optional<Vehicle> lastVehicleOpt = vehicleRepository.findTopByModelAndTypeOrderByRegistrationNoDesc(model,
                type);
        int sequenceNumber = 0;

        if (lastVehicleOpt.isPresent()) {
            Vehicle lastVehicle = lastVehicleOpt.get();
            String lastRegNo = lastVehicle.getRegistrationNo();
            String lastSequenceStr = lastRegNo.substring(lastRegNo.length() - 4);
            sequenceNumber = Integer.parseInt(lastSequenceStr);
        }

        String sequenceStr = String.format("%04d", sequenceNumber);

        return year + modelCode + typeCode + sequenceStr;
    }

    public String incrementRegestrationNo(String redgNo) {
        // int sequence = 0;
        String lastSequenceStr = redgNo.substring(redgNo.length() - 4);
        int sequence = Integer.parseInt(lastSequenceStr) + 1;
        String sequenceStr = String.format("%04d", sequence);

        return redgNo.substring(0, redgNo.length() - 4) + sequenceStr;

    }

}
