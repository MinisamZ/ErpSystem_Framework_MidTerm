package com.example.ERP.System.model;

import com.example.ERP.System.model.base.BaseDTO;

import java.util.List;

public class UserDto extends BaseDTO {

    public Long user;

    public String login;
    public String role;

    public String fio;
    public String firstName;
    public String lastName;
    public String middleName;

    public String email;
    public String phone;
    public Boolean active;
    public String createdAt;
    public List<String> permissions;

    public UserDto(User user) {

        active = user.getActive();
        login = user.getLogin();


    }

}
