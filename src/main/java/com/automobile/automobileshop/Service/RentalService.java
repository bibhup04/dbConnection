package com.automobile.automobileshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automobile.automobileshop.Entity.Rental;
import com.automobile.automobileshop.Repository.RentalRepository;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public void saveOrUpdateRental(Rental rental) {
        rentalRepository.save(rental);
    }

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }

}
