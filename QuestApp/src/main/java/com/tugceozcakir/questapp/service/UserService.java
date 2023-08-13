package com.tugceozcakir.questapp.service;

import com.tugceozcakir.questapp.database.entity.UserEntity;
import com.tugceozcakir.questapp.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAllUsers(){
       return userRepository.findAll();
    }

    public UserEntity createUser(@RequestBody UserEntity newUser){
        return userRepository.save(newUser);
    }

    public UserEntity getOneUserById(@PathVariable Long userId){
        //custom exception
        return userRepository.findById(userId).orElse(null);
    }

    public UserEntity updateUserById(@PathVariable Long userId, @RequestBody UserEntity newUser){
        Optional<UserEntity> user = userRepository.findById(userId);
        if(user.isPresent()){
            UserEntity foundUser = user.get();
            foundUser.setId(newUser.getId());
            foundUser.setPassword(newUser.getPassword());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        }else{
            return null;
        }
    }

    public void delete(@PathVariable Long userId){
        userRepository.deleteById(userId);
    }
}
