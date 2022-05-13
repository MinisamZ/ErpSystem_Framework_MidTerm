package com.example.ERP.System.util.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class PasswordAuthentication implements Authentication {
    private String name;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean isAuthenticated;
    private UserDetails principal;

    public PasswordAuthentication(String name, String password, List<GrantedAuthority> grantedAuthorities,
            UserDetails principal) {
        this.name = name;
        this.password = password;
        this.authorities = grantedAuthorities;
        this.principal = principal;
        isAuthenticated = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return password;
    }

    @Override
    public Object getDetails() {
        return password;
    }


    @Override
    public String getName() {
        if (principal != null) { return ((UserDetails) principal).getUsername(); } else { return null; }
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        isAuthenticated = b;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
