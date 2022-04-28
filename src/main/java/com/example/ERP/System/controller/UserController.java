package com.example.ERP.System.controller;

import com.example.ERP.System.model.User;
import com.example.ERP.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/byId/{id}")
    public User deleteUser(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PostMapping("/user/create")
    public User createUser(User user) {
        return userService.createUser(user);
    }
    @PostMapping("/user/createMoreOne")
    public List<User> createUser(List<User> users) {
        return userService.createUsers(users);
    }

    @PostMapping("/user/updateById/{id}")
    public User updateUserWithoutPass(@PathVariable("id") Long id, User user) {
        User user1 = userService.getById(id);
        if (user.getLogin() != null || !user.getLogin().equals(""))
            user1.setLogin(user.getLogin());
        if (user.getName() != null || !user.getName().equals(""))
            user1.setName(user.getName());
        if (user.getCountry() != null || !user.getCountry().equals(""))
            user1.setCountry(user.getCountry());
        if (user.getGender() != null || !user.getGender().equals(""))
            user1.setGender(user.getGender());
        return userService.createUser(user1);
    }

    @PostMapping("/user/updPassById/{id}")
    public User updatePassById(@PathVariable("id") Long id, String pass) {
        User user1 = userService.getById(id);
        user1.setPassword(pass);
        return userService.createUser(user1);

    }


}
