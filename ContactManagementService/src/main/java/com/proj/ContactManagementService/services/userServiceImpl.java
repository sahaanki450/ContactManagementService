package com.proj.ContactManagementService.services;

import com.proj.ContactManagementService.entities.User;
import com.proj.ContactManagementService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService{

    @Autowired
    UserRepository repository;


    @Override
    public User save(User user) {

        User saved_user = repository.save(user);
        return saved_user;
    }
}
