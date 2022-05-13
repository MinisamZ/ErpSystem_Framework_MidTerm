package com.example.ERP.System.model;

import com.example.ERP.System.model.base.BaseForm;

public class LoginForm extends BaseForm {

    public String login;

    public String password;

    public LoginForm() {
    }

    public LoginForm(String login, String password) {
        this.login = login;
        this.password = password;
    }


    @Override
    public String toString() {
        return "LoginForm{" + "login='" + login + '\'' + ", password='" + password + '\'' + '}';
    }
}
