package com.tugceozcakir.healthtourismproject.service;

import com.tugceozcakir.healthtourismproject.database.entity.UserEntity;
import com.tugceozcakir.healthtourismproject.database.repository.UserRepository;
import com.tugceozcakir.healthtourismproject.database.specification.UserSpecification;
import com.tugceozcakir.healthtourismproject.mapper.UserMapper;
import com.tugceozcakir.healthtourismproject.model.UserDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.UserRequestDTO;
import com.tugceozcakir.healthtourismproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<
        UserEntity,
        UserDTO,
        UserRequestDTO,
        UserMapper,
        UserRepository,
        UserSpecification
        > {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserSpecification userSpecification;

    @Override
    protected UserMapper getMapper() {
        return userMapper;
    }

    @Override
    protected UserRepository getRepository() {
        return userRepository;
    }

    @Override
    protected UserSpecification getSpecification() {
        return userSpecification;
    }
}
