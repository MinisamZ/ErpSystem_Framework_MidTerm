package com.example.ERP.System.service;

import com.example.ERP.System.repository.SaleRepository;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }
}
