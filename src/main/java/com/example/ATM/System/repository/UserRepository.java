package com.example.ATM.System.repository;

import com.example.ATM.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;

public interface UserRepository extends JpaRepository<User, Long> {


}
