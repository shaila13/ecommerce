package com.icodeap.ecommerce.application.usescases;

import com.icodeap.ecommerce.domain.ports.in.LoginService;
import org.springframework.security.core.userdetails.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final LoginService loginService;

    private final HttpSession httpSession;

    public UserDetailServiceImpl(LoginService loginService, HttpSession httpSession) {
        this.loginService = loginService;
        this.httpSession = httpSession;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = Optional.ofNullable(loginService.getUserByEmail(username)).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        httpSession.setAttribute("iduser", user.getId());
        return User.builder().username(user.getUserName())
                .password(user.getPassword())
                .roles(user.getUserType().name())
                .build();
    }
}
