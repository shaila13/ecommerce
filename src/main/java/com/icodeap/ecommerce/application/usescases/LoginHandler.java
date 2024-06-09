package com.icodeap.ecommerce.application.usescases;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;


@Component
public class LoginHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Optional<String> redirectURL = userDetails.getAuthorities().stream()
                .map(grantedAuthority -> "ROLE_ADMIN".equals(grantedAuthority.getAuthority()) ? "/admin" : "/admin")
                //.map(grantedAuthority -> "ROLE_ADMIN".equals(grantedAuthority.getAuthority()) ? "/admin" : "/home")
                .findFirst();

        response.sendRedirect(contextPath + redirectURL.orElse("/home"));
    }
}
