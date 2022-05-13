package com.example.ERP.System.service;

import com.example.ERP.System.model.User;
import com.example.ERP.System.repository.UserRepository;
import com.example.ERP.System.util.security.MyUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userDao;


    @Autowired
    public UserService userRoleService;


    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        User user = userDao.getUserByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("");
        }
        return new MyUserPrincipal(user);
    }
}