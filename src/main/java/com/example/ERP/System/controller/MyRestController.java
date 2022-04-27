package com.example.ERP.System.controller;

import com.example.ERP.System.model.Stock;
import com.example.ERP.System.service.TextileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {
    private final TextileService textileService;

    @Autowired
    public MyRestController(TextileService textileService) {
        this.textileService = textileService;
    }

    @GetMapping(value = "/test")
    public String getTest() {
        System.out.println(textileService.findAllStocks());
        return "asd";
    }

}
