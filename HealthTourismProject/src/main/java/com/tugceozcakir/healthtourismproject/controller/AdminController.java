package com.tugceozcakir.healthtourismproject.controller;

import com.tugceozcakir.healthtourismproject.database.entity.AdminEntity;
import com.tugceozcakir.healthtourismproject.database.repository.AdminRepository;
import com.tugceozcakir.healthtourismproject.database.specification.AdminSpecification;
import com.tugceozcakir.healthtourismproject.mapper.AdminMapper;
import com.tugceozcakir.healthtourismproject.model.AdminDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.AdminRequestDTO;
import com.tugceozcakir.healthtourismproject.service.AdminService;
import com.tugceozcakir.healthtourismproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController<
        AdminEntity,
        AdminDTO,
        AdminRequestDTO,
        AdminMapper,
        AdminRepository,
        AdminSpecification,
        AdminService> {

    @Autowired
    AdminService adminService;

    @Override
    protected AdminService getService() {
        return adminService;
    }
}
