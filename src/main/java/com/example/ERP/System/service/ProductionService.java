package com.example.ERP.System.service;

import com.example.ERP.System.repository.InfoRepository;
import com.example.ERP.System.repository.ProductionRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductionService {
    private final InfoRepository infoRepository;
    private final ProductionRepository productionRepository;

    public ProductionService(InfoRepository infoRepository, ProductionRepository productionRepository) {
        this.infoRepository = infoRepository;
        this.productionRepository = productionRepository;
    }
}
