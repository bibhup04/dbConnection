package com.automobile.automobileshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automobile.automobileshop.Entity.Sale;
import com.automobile.automobileshop.Repository.SaleRepository;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(Long id) {
        return saleRepository.findById(id).orElse(null);
    }

    public void saveOrUpdateSale(Sale sale) {
        saleRepository.save(sale);
    }

    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

}
