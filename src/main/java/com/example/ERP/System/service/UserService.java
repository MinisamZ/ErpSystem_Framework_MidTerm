package com.example.ERP.System.service;

import com.example.ERP.System.model.User;

import java.util.List;

public interface UserService {
    User getById(Long id);

    User createUser(User user);

    List<User> createUsers(List<User> users);

    User login(String name, String password);

    User getByLogin(String login);

    void update(User u);
}
