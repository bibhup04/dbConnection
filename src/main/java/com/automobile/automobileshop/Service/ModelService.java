package com.automobile.automobileshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automobile.automobileshop.Entity.Model;
import com.automobile.automobileshop.Repository.ModelRepository;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    public Model getModelById(Long id) {
        return modelRepository.findById(id).orElse(null);
    }

    public void saveOrUpdateModel(Model model) {
        modelRepository.save(model);
    }

    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

    public Model getModelTypeByModelName(String modelName) {
        return modelRepository.findByModelName(modelName)
                .orElseThrow(() -> new RuntimeException("ModelType not found with modelName: " + modelName));
    }

}
