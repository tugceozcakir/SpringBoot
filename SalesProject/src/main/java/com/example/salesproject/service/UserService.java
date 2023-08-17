package com.example.salesproject.service;

import com.example.salesproject.database.entity.RoleEntity;
import com.example.salesproject.database.entity.UserEntity;
import com.example.salesproject.database.repository.RoleRepository;
import com.example.salesproject.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    public void saveUserByRole(UserEntity user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findByName("user").get());
        user.setRoles(roles);
        userRepository.save(user);
    }


}
