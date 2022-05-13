package com.example.ERP.System.service;

import com.example.ERP.System.model.User;
import com.example.ERP.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public List<User> createUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public User login(String name, String password) {
        return userRepository.findAll().get(0);
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    public void update(User u) {
        userRepository.save(u);
    }

//    public Long get
}
