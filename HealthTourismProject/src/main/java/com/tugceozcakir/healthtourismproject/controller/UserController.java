package com.tugceozcakir.healthtourismproject.controller;

import com.tugceozcakir.healthtourismproject.database.entity.UserEntity;
import com.tugceozcakir.healthtourismproject.database.repository.UserRepository;
import com.tugceozcakir.healthtourismproject.database.specification.UserSpecification;
import com.tugceozcakir.healthtourismproject.mapper.UserMapper;
import com.tugceozcakir.healthtourismproject.model.UserDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.UserRequestDTO;
import com.tugceozcakir.healthtourismproject.service.UserService;
import com.tugceozcakir.healthtourismproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<
        UserEntity,
        UserDTO,
        UserRequestDTO,
        UserMapper,
        UserRepository,
        UserSpecification,
        UserService> {

    @Autowired
    UserService userService;

    @Override
    protected UserService getService() {
        return userService;
    }
}
