package com.example.ERP;

import com.example.ERP.System.model.RoleEnum;
import com.example.ERP.System.model.User;
import com.example.ERP.System.service.UserServiceImpl;
import com.example.ERP.util.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static com.example.ERP.System.model.RND.rndStr;

public class UserServiceImplTest extends BaseTest {

    @Autowired
    public UserServiceImpl userService;

    @Test
    public void testRole() {
        User u = new User();
        u.setLogin(rndStr(10));
        u.setPassword(rndStr(12));
        u.setRole(RoleEnum.ADMIN);

        userService.createUser(u);


        User u2 = userService.getByLogin(u.getLogin());
        u2.setRole(RoleEnum.USER);
        userService.update(u2);
        System.out.println(u2);
    }

    @Test
    public void testUser() {
        User u = new User();
        u.setLogin("sam");
        u.setPassword("123");
        u.setRole(RoleEnum.ADMIN);

        userService.createUser(u);

    }

}
