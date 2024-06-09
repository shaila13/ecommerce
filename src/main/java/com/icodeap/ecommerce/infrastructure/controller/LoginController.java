package com.icodeap.ecommerce.infrastructure.controller;

import com.icodeap.ecommerce.domain.models.UserType;
import com.icodeap.ecommerce.domain.ports.in.LoginService;
import com.icodeap.ecommerce.domain.models.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String login(){
        return "login";
    }

    @GetMapping("/access")
    public String access(RedirectAttributes attributes, HttpSession httpSession){
        String userIdStr = httpSession.getAttribute("iduser").toString();
        User user = loginService.getUserById(Integer.parseInt(userIdStr));
        attributes.addFlashAttribute("id", userIdStr);
        return (loginService.existUser(user.getEmail()) &&
                loginService.getUserType(user.getEmail()) == UserType.ADMIN) ? "redirect:/admin" : "redirect:/home";

    }
}
