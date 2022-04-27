package com.example.ERP.System.service;

import com.example.ERP.System.model.Stock;
import com.example.ERP.System.model.Textile;
import com.example.ERP.System.repository.StockRepository;
import com.example.ERP.System.repository.TextileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextileService {
    private final TextileRepository textileRepository;
    private final StockRepository stockRepository;

    @Autowired
    public TextileService(TextileRepository textileRepository, StockRepository stockRepository) {
        this.textileRepository = textileRepository;
        this.stockRepository = stockRepository;
    }
    public List<Stock> findAllStocks(){
        return stockRepository.findAll();
    }

    public Textile findById(Long id) {
        return textileRepository.getById(id);
    }

    public List<Textile> findAll() {
        return textileRepository.findAll();
    }

    public Textile saveTextile(Textile textile) {
        return textileRepository.save(textile);
    }

    public void deleteById(Long id) {
        textileRepository.deleteById(id);
    }

    public void updateById(long i, int s) {
        System.out.println("updateById");
        System.out.println(i + "-" + s);

        textileRepository.updateMaterial(i, s);
    }
}
