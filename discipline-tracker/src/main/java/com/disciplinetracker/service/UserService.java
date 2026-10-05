package com.disciplinetracker.service;

import com.disciplinetracker.model.User;
import com.disciplinetracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public User getUser(Long id) {
        User getUser = userRepository
                .findById(id)
                .orElse(null);
        return getUser;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public void deleteUser(Long id) {
        if (id == null) {
            return;
        }
        userRepository.deleteById(id);
    }

    public User updateUser(Long id , User updatedUser){
        User existingUser = userRepository.findById(id)
                .orElse(null);

        existingUser.setUserName(updatedUser.getUserName());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        existingUser.setEmailId(updatedUser.getEmailId());
        existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
        existingUser.setPassword(updatedUser.getPassword());
        return userRepository.save(existingUser);
    }
}
