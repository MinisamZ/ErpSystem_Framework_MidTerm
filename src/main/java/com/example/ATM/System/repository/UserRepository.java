package com.example.ATM.System.repository;

import com.example.ATM.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
