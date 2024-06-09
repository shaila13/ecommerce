package com.icodeap.ecommerce.domain.ports.in;

import com.icodeap.ecommerce.domain.ports.out.UserRepository;
import com.icodeap.ecommerce.domain.models.User;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> createUser(User user){
        return Optional.ofNullable(userRepository.createUser(user));
    }
    public Optional<User> findByEmail(String email){
        return Optional.ofNullable(userRepository.findByEmail(email));
    }
    public Optional<User> findById (Integer id){
        return Optional.ofNullable(userRepository.findById(id));
    }
}
