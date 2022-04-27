package com.example.ERP.System.controller;

import com.example.ERP.System.service.TextileService;
import com.example.ERP.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    private final TextileService textileService;
    private final UserService userService;

    @Autowired
    public MyRestController(TextileService textileService, UserService userService) {
        this.textileService = textileService;
        this.userService = userService;
    }

    @GetMapping(value = "/test")
    public String getTest() {
//        System.out.println(textileService.findAllStocks());
        System.out.println(userService.getById(1L));
        return "asd";
    }

}
