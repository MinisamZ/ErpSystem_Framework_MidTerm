package com.example.ATM.System.repository;

import com.example.ATM.System.model.User;
import com.example.ATM.System.service.BankService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BankAccountRepositroy extends JpaRepository<User, Long>{

    @Query("select b from User b where b.cardNumber = :сard_number")
    User findByCardNumber(@Param("сard_number") String cardNumber);
}
