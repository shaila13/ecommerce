package com.icodeap.ecommerce.infrastructure.configuration;

import com.icodeap.ecommerce.application.usescases.LoginHandler;
import com.icodeap.ecommerce.application.usescases.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailServiceImpl userDetailService;

    private final LoginHandler loginHandler;

    public SecurityConfig(UserDetailServiceImpl userDetailService, LoginHandler loginHandler) {
        this.userDetailService = userDetailService;
        this.loginHandler = loginHandler;
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER").anyRequest().permitAll()
                .and().formLogin().loginPage("/login").successHandler(loginHandler) .and().logout().logoutSuccessUrl("/close");
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
