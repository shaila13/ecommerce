package com.icodeap.ecommerce.domain.ports.in;

import com.icodeap.ecommerce.domain.models.User;
import com.icodeap.ecommerce.domain.models.UserType;

public class LoginService {
    private final UserService userService;

    public LoginService(UserService userService) {
        this.userService = userService;
    }

    //retorna true si encuentra el user
    public boolean existUser(String email){
        return userService.findByEmail(email).isPresent();
    }

    //obtenemos el id del usuario
    public Integer getUserId(String email){
        return userService.findByEmail(email)
                .map(User::getId)
                .orElse(0);
    }

    //obtener tipo de usuario
    public UserType getUserType(String email){
        return userService.findByEmail(email).get().getUserType();
    }

    //obtenemos el user por email
    public User getUserByEmail(String email){
        return userService.findByEmail(email).orElse(new User());
    }

    //obtenemos el user por id
    public User getUserById(Integer id){
        return userService.findById(id).orElse(new User());
    }

}
