package com.example.ERP.System.repository;

import com.example.ERP.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByLogin(String username);

    List<User> getUsersByActive(Boolean b);

}
