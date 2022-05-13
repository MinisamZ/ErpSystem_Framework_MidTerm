package com.example.ERP.System.service;

import com.example.ERP.System.model.LoginForm;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

public interface AuthService {


    Authentication auth(@RequestBody LoginForm form, HttpSession session);
}
