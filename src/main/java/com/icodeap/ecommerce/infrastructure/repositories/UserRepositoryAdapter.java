package com.icodeap.ecommerce.infrastructure.repositories;

import com.icodeap.ecommerce.domain.ports.out.UserRepository;
import com.icodeap.ecommerce.domain.models.User;
import com.icodeap.ecommerce.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryAdapter implements UserRepository {
    private final UserCrudRepository userCrudRepository;
    private final UserMapper userMapper;

    public UserRepositoryAdapter(UserCrudRepository userCrudRepository, UserMapper userMapper) {
        this.userCrudRepository = userCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(User user) {
        return userMapper.toUser(userCrudRepository.save( userMapper.toUserEntity(user) ));
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.toUser(userCrudRepository.findByEmail(email).get());
    }

    @Override
    public User findById(Integer id) {
        return userMapper.toUser(userCrudRepository.findById(id).get());
    }
}
