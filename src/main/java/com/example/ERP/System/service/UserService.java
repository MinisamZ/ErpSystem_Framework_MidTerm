package com.example.ERP.System.service;

import com.example.ERP.System.model.User;
import com.example.ERP.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(Long id) {
        return userRepository.getById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
    public List<User> createUsers(List<User> users) {
        return userRepository.saveAll(users);
    }
//    public Long get
}
