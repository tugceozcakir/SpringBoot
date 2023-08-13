package com.tugceozcakir.questapp.controller;

import com.tugceozcakir.questapp.database.entity.UserEntity;
import com.tugceozcakir.questapp.database.repository.UserRepository;
import com.tugceozcakir.questapp.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity newUser){
        return createUser(newUser);
    }

    @GetMapping("/{userId}")
    public UserEntity getOneUserById(@PathVariable Long userId){
        //custom exception
        return userService.getOneUserById(userId);
    }

    @PutMapping("/{userId}")
    public UserEntity updateUserById(@PathVariable Long userId, @RequestBody UserEntity newUser){
        return userService.updateUserById(userId, newUser);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId){
        userService.delete(userId);
    }
}
