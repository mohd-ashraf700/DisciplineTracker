package com.disciplinetracker.service;

import com.disciplinetracker.model.User;
import com.disciplinetracker.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        User userRes = userRepository.save(user);
        return userRes;
    }
}
