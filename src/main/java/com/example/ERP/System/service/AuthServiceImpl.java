package com.example.ERP.System.service;

import com.example.ERP.System.model.LoginForm;
import com.example.ERP.System.repository.UserRepository;
import com.example.ERP.System.util.security.CustomAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@Component
public class AuthServiceImpl implements AuthService {

    @Autowired
    private CustomAuthProvider authProvider;


    @Autowired
    public UserRepository userDao;

    @Override
    public Authentication auth(@RequestBody LoginForm form, HttpSession session) {
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
                form.login, form.password);
        Authentication auth = authProvider.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);

        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
        return auth;
    }

    public static boolean isGreaterZero(BigDecimal num) {
        if (num.compareTo(new BigDecimal(0)) > 0) {
            return true;
        }
        return false;
    }

    public static BigDecimal round(BigDecimal num) {
        num = num.setScale(2, RoundingMode.DOWN);
        return num;
    }

    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal(-2471);
        BigDecimal cashBack = new BigDecimal(123.55);

        BigDecimal prc = round(cashBack.divide(amount, MathContext.DECIMAL128)
                .multiply(new BigDecimal(100)));
        if (!isGreaterZero(prc)) {
            prc = prc.multiply(new BigDecimal(-1));
        }
        prc = prc.divide(new BigDecimal(0.25));
        System.out.println(prc);
        prc = prc.setScale(0, RoundingMode.HALF_EVEN);
        prc = prc.multiply(new BigDecimal(0.25));
        System.out.println(prc);
    }


}
