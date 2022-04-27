package com.example.ERP.System.controller;

import com.example.ERP.System.model.Textile;
import com.example.ERP.System.service.TextileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TextileController {
    private final TextileService textileService;

    @Autowired
    public TextileController(TextileService textileService) {
        this.textileService = textileService;
    }

//    @GetMapping(value = "/test")
//    public String getTest() {
//        return textileService.findAll().toString();
//    }

    @GetMapping(value = "/")
    public String getHomePage() {
        return "home";
    }

    @GetMapping(value = "/hello")
    public String getHelloPage() {
        return "hello";
    }

    @RequestMapping(value = "/main")
    public String getMainPage() {
        return "main-page";
    }

    @RequestMapping(value = "/list")
    public String getListOfAccountsForAdmin(Model model) {
        List<Textile> textiles = textileService.findAll();
        model.addAttribute("textiles", textiles);
        return "list";
    }

    @RequestMapping(value = "/user/buy")
    public String getListOfAccountsForUser(Model model) {
        List<Textile> textiles = textileService.findAll();
        model.addAttribute("textiles", textiles);
        return "user/buy";
    }

    @GetMapping("textile-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        textileService.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping("user/textile-buyItem/{id}")
    public String buyTextile(@PathVariable("id") Long id, Model model) {
        Textile textile = textileService.findById(id);
        System.out.println(textile);
        model.addAttribute("textile", textile);
        return "/user/buyItem";
    }

//    @RequestMapping(value = "user/textile-buyItem/", method = RequestMethod.POST)
//    public String buyTextile2( Textile textile) {

    @PostMapping("user/textile-buyItem")
    public String buyTextile2(Textile textile) {
        System.out.println("buyTextile2");
        int count = textile.getQuantity();
        textile.setQuantity(textile.getQuantity() - count);
        System.out.println(textile.getQuantity() + " " + textile.getId());
        textile.setQuantity(50);
        System.out.println(textile);
//        textileService.updateById(textile.getId(),textile.getQuantity());
        return "user/buy";

    }

    @RequestMapping(value = "/textile-create")
    public String getTextileCreate() {
        return "textile-create";
    }

    @PostMapping(value = "/textile-create")
    public void postTextileCreate(Textile textile) {
        textileService.saveTextile(textile);
    }

    @GetMapping(value = "/error")
    public String error() {
        return "error";
    }

}
