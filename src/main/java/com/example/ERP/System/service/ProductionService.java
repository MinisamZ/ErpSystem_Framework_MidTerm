package com.example.ERP.System.service;

import com.example.ERP.System.model.Info;
import com.example.ERP.System.model.Production;
import com.example.ERP.System.repository.InfoRepository;
import com.example.ERP.System.repository.ProductionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionService {
    private final InfoRepository infoRepository;
    private final ProductionRepository productionRepository;

    public ProductionService(InfoRepository infoRepository, ProductionRepository productionRepository) {
        this.infoRepository = infoRepository;
        this.productionRepository = productionRepository;
    }

    public Info findInfo() {
        return infoRepository.findAll().get(0);
    }

    public Info saveInfo(Info info) {
        return infoRepository.save(info);
    }

    public Production getById(Long id){
        return productionRepository.getById(id);
    }
    public List<Production> getProductionList(){
        return productionRepository.findAll();
    }
    public Production saveProduction(Production p){
        return productionRepository.save(p);
    }
}
