package com.example.ATM.System.controller;

import com.example.ATM.System.model.User;
import com.example.ATM.System.repository.BankAccountRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ATMController {
    private final BankAccountRepositroy bankAccountRepositroy;

    @Autowired
    public ATMController(BankAccountRepositroy bankAccountRepositroy) {
        this.bankAccountRepositroy = bankAccountRepositroy;
    }

    @GetMapping("/atm")
    public String findOneUser(@RequestParam(name = "name") String cardNumber, Model model) {
        System.out.println(cardNumber);
        User user = bankAccountRepositroy.findByCardNumber(cardNumber);
        System.out.println(user);
        model.addAttribute("user", user);
        return "user/atm";
    }

    @PostMapping("/user/login")
    public String login(User user, Model model) {
        System.out.println("123");
        bankAccountRepositroy.verification(user.cardNumber, user.getPassword());
        user = bankAccountRepositroy.findByCardNumber(user.cardNumber);
        model.addAttribute("user", user);
        return "user/atm";
    }

    @GetMapping("/user/login/{cardNumber}")
    public String login(@PathVariable("cardNumber") String cardNumber, Model model) {
        User user = bankAccountRepositroy.findByCardNumber(cardNumber);
        model.addAttribute("user", user);
        System.out.println(user.toString());
        return "user/login";
    }

    @GetMapping("/user/balance/{cardNumber}")
    public String balance(@PathVariable("cardNumber") String cardNumber, Model model) {
        System.out.println("balance");
        User user = bankAccountRepositroy.findByCardNumber(cardNumber);
        model.addAttribute("user", user);
        System.out.println(user.toString());
        return "user/balance";
    }
}
