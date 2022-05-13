package com.example.ERP.System.util.security;

import com.example.ERP.System.model.User;
import com.example.ERP.System.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CustomAuthProvider implements AuthenticationProvider {

    private UserService userService;


    public CustomAuthProvider(UserService userService) {
        this.userService = userService;
    }


    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        Object credentials = authentication.getCredentials();
        if (!(credentials instanceof String)) {
            return null;
        }
        String password = credentials.toString();
        User login = userService.login(name, password);
        if (login != null) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + login.getRole().name()));
            return new PasswordAuthentication(name, password, grantedAuthorities,
                    new MyUserPrincipal(login));
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }


}
