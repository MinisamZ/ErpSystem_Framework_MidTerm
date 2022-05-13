package com.example.ERP.System.controller;

import com.example.ERP.System.model.LoginForm;
import com.example.ERP.System.model.UserDto;
import com.example.ERP.System.model.rest.RestResponse;
import com.example.ERP.System.service.AuthService;
import com.example.ERP.System.service.TextileService;
import com.example.ERP.System.service.UserServiceImpl;
import com.example.ERP.System.util.security.MyUserPrincipal;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.example.ERP.System.model.rest.RestResponse.NOT_FOUND;

@RestController
@RequestMapping("/test")
public class MyRestController {
    private final TextileService textileService;
    private final UserServiceImpl userService;

    @Autowired
    public AuthService authService;

    @Autowired
    public MyRestController(TextileService textileService, UserServiceImpl userService) {
        this.textileService = textileService;
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @GetMapping(value = "/ping")
    public String getTest() {
//        System.out.println(textileService.findAllStocks());
        System.out.println(userService.getById(1L));
        return "asd";
    }

    @GetMapping(value = "/sing")
    public String gsetTest() {
//        System.out.println(textileService.findAllStocks());
        System.out.println(userService.getById(1L));
        return "asd";
    }

    @ApiOperation(value = "Авторизация в приложение через апи")
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public RestResponse loginGET(@RequestParam("login") String login, @RequestParam("password") String password,
                                 HttpServletRequest req) {

        Authentication auth = authService.auth(new LoginForm(login, password), req.getSession(true));

        if (auth != null && auth.isAuthenticated()) {
            return RestResponse.ok().addData(new UserDto(((MyUserPrincipal) auth.getPrincipal()).getUserAccount()));
        } else {
            return RestResponse.create(NOT_FOUND);
        }

    }

    @ApiOperation(value = "Выход из учетки")
    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public RestResponse logout(HttpServletRequest request) {
        new SecurityContextLogoutHandler().logout(request, null, null);
        return RestResponse.ok();
    }

}
