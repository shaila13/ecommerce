package com.icodeap.ecommerce.infrastructure.service;

import com.icodeap.ecommerce.application.service.LoginService;
import com.icodeap.ecommerce.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final LoginService loginService;
    private final Integer USER_NOT_FOUND = 0;
    @Autowired
    private HttpSession httpSession;

    public UserDetailServiceImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Integer idUser = loginService.getUserId(username);
        if (idUser != USER_NOT_FOUND){
            User user = loginService.getuser(username);
            httpSession.setAttribute("iduser", user.getId());
            return org.springframework.security.core.userdetails.User.builder().username(user.getUserName()).password(user.getPassword()).roles(user.getUserType().name()).build();
        }else{
            throw  new UsernameNotFoundException("Usuario no encontrado ");
        }

    }
}
