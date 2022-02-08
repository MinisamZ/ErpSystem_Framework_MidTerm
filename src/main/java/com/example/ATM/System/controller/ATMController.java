package com.example.ATM.System.controller;

import com.example.ATM.System.model.User;
import com.example.ATM.System.repository.BankAccountRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ATMController {
    private final BankAccountRepositroy bankAccountRepositroy;

    @Autowired
    public ATMController(BankAccountRepositroy bankAccountRepositroy) {
        this.bankAccountRepositroy = bankAccountRepositroy;
    }

    @GetMapping("/search-user")
    public String findOneUser(@RequestParam(name = "name") String cardNumber,Model model) {
        System.out.println(cardNumber);
        User user = bankAccountRepositroy.findByCardNumber(cardNumber);
        System.out.println(user);
        model.addAttribute("user", user);
        return "user/user-page";
    }

}
