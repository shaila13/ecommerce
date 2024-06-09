package com.icodeap.ecommerce.domain.ports.in;

import jakarta.servlet.http.HttpSession;

public class LogoutService {
    public LogoutService() {
    }

    public void logout(HttpSession httpSession){
        httpSession.removeAttribute("iduser");
    }
}
