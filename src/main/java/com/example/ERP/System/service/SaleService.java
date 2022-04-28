package com.example.ERP.System.service;

import com.example.ERP.System.model.Sale;
import com.example.ERP.System.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getAll() {
        return saleRepository.findAll();
    }
    public Sale save(Sale sale){return saleRepository.save(sale);}

}
