package com.usecase.controller;

import com.usecase.entity.User;
import com.usecase.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    
    @GetMapping("/users/{user_id}")
    public User getUserById(@PathVariable Long user_id){
        return userService.getUserById(user_id);
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User Added Successfully with ID - " + user.getUserId();
    }
    
    @DeleteMapping("/users/{user_id}")
    public String deleteUser(@PathVariable Long user_id) {
        userService.deleteUser(user_id);
        return "User Deleted Successfully with ID - " + user_id;
   }
    
    @PutMapping("/users/{user_id}")
    public String updateUser(@PathVariable Long user_id, @RequestBody User user) {
        userService.updateUser(user_id, user);
        return "User Updated Successfully with ID - " + user_id;
    }
}
