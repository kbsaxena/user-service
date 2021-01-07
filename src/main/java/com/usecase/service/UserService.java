package com.usecase.service;

import com.usecase.entity.User;
import com.usecase.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(new User());
    }

    public void addUser(User user) {
         userRepository.save(user);
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
   }

    public void updateUser(Long id, User updatedUser) {
        User user = getUserById(id);
        user.setFullName(updatedUser.getFullName());
        user.setAddress(updatedUser.getAddress());
        user.setCity(updatedUser.getCity());
        user.setState(updatedUser.getState());
        
        addUser(user);
    }
}
