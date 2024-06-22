package com.automobile.automobileshop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automobile.automobileshop.DTO.BrandModelDTO;
import com.automobile.automobileshop.Entity.Brand;
import com.automobile.automobileshop.Entity.Model;
import com.automobile.automobileshop.Repository.BrandRepository;

import jakarta.transaction.Transactional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelService modelService;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrandById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    public Brand getBrandByName(String brandName) {
        Optional<Brand> brand = brandRepository.findByBrandName(brandName);
        return brand.orElse(null);
    }

    public void saveOrUpdateBrand(Brand brand) {
        brandRepository.save(brand);
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }

    @Transactional
    public void addBrandAndModel(BrandModelDTO brandModelDTO) {

        Brand brand = getBrandByName(brandModelDTO.getBrandName());

        if (brand == null) {
            brand = new Brand();
            brand.setBrandName(brandModelDTO.getBrandName());
            brandRepository.save(brand);
        }

        Model model = new Model();
        model.setModelName(brandModelDTO.getModelName());
        model.setBrand(brand);

        modelService.saveOrUpdateModel(model);
    }

}
