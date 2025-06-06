package com.assignment.service;

import com.assignment.entity.UserEntity;
import com.assignment.model.User;
import com.assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(user.getEmail());
        userEntity.setName(user.getName());
        userEntity.setDateOfBirth(Date.valueOf(user.getDateOfBirth()));
        return userRepository.save(userEntity);
    }

    public Optional<UserEntity> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<UserEntity> updateUser(Long id, User user) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return optionalUser;
        }
        UserEntity userEntity = optionalUser.get();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setDateOfBirth(Date.valueOf(user.getDateOfBirth()));

        return Optional.ofNullable(userRepository.save(userEntity));
    }
}
