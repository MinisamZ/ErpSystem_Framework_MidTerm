package com.example.ATM.System.service;

import com.example.ATM.System.repository.BankAccountRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    private final BankAccountRepositroy bankAccountRepositroy;

    @Autowired
    public BankService(BankAccountRepositroy bankAccountRepositroy) {
        this.bankAccountRepositroy = bankAccountRepositroy;
    }
}
