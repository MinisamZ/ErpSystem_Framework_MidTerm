package com.example.ERP.System.controller;

import com.example.ERP.System.model.Info;
import com.example.ERP.System.model.Production;
import com.example.ERP.System.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductionController {
    private final ProductionService productionService;

    @Autowired
    public ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @GetMapping("/info")
    public Info getInfo() {
        return productionService.findInfo();
    }

    @PostMapping("/info/update")
    public Info updateInfo(Info info) {
        Info infolocal = productionService.findInfo();
        if (info.getBudget() != null)
            infolocal.setBudget(info.getBudget());
        if (info.getIncome() != null)
            infolocal.setIncome(info.getIncome());
        if (info.getCosts() != null)
            infolocal.setCosts(info.getCosts());
        infolocal.setActual(null);
        return productionService.saveInfo(infolocal);
    }

    @GetMapping("/production/list")
    public List<Production> getProduction() {
        return productionService.getProductionList();
    }

    @PostMapping("/production/updateById/{id}")
    public Production updateProduction(@PathVariable("id") Long id, Production production) {
        Production productionl = productionService.getById(id);
        if (production.getQuantity() != null || production.getQuantity() > 0)
            productionl.setQuantity(production.getQuantity());
        productionl.setActual(null);
        return productionService.saveProduction(productionl);
    }

    @PostMapping("/production/updateById/{id}&{quantity}")
    public Production updateProduction2(@PathVariable("id") Long id, @PathVariable("quantity") Long quantity) {
        Production productionl = productionService.getById(id);
        if (quantity != null || quantity > 0)
            productionl.setQuantity(quantity);
        productionl.setActual(null);
        return productionService.saveProduction(productionl);
    }


}
