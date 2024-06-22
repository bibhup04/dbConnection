package com.automobile.automobileshop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automobile.automobileshop.DTO.BrandModelDTO;
import com.automobile.automobileshop.Entity.Brand;
import com.automobile.automobileshop.Service.BrandService;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public Brand getBrandById(@PathVariable Long id) {
        return brandService.getBrandById(id);
    }

    @PostMapping
    public void addBrand(@RequestBody Brand brand) {
        brandService.saveOrUpdateBrand(brand);
    }

    @PutMapping("/{id}")
    public void updateBrand(@PathVariable Long id, @RequestBody Brand brand) {
        brand.setId(id);
        brandService.saveOrUpdateBrand(brand);
    }

    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);
    }

    @PostMapping("/addWithModel")
    public ResponseEntity<String> addBrandAndModel(@RequestBody BrandModelDTO brandModelDTO) {
        brandService.addBrandAndModel(brandModelDTO);
        return new ResponseEntity<>("Brand amd model added successfully", HttpStatus.OK);
    }

}
