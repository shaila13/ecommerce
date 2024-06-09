package com.icodeap.ecommerce.domain.ports.out;

import com.icodeap.ecommerce.domain.models.User;

public interface UserRepository {
    public User createUser(User user);
    public User findByEmail(String email);
    public User findById(Integer id);

}
