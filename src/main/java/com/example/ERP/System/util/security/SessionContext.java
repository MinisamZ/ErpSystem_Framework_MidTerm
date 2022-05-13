package com.example.ERP.System.util.security;

import com.example.ERP.System.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SessionContext {

    public static User getUserAccount() {

        MyUserPrincipal context = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return context.getUserAccount();
    }

}