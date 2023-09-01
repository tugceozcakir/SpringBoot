package com.tugceozcakir.healthtourismproject.service;

import com.tugceozcakir.healthtourismproject.database.entity.AdminEntity;
import com.tugceozcakir.healthtourismproject.database.repository.AdminRepository;
import com.tugceozcakir.healthtourismproject.database.specification.AdminSpecification;
import com.tugceozcakir.healthtourismproject.mapper.AdminMapper;
import com.tugceozcakir.healthtourismproject.model.AdminDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.AdminRequestDTO;
import com.tugceozcakir.healthtourismproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends BaseService<
        AdminEntity,
        AdminDTO,
        AdminRequestDTO,
        AdminMapper,
        AdminRepository,
        AdminSpecification> {


    @Autowired
    AdminMapper adminMapper;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AdminSpecification adminSpecification;

    @Override
    protected AdminMapper getMapper() {
        return adminMapper;
    }

    @Override
    protected AdminRepository getRepository() {
        return adminRepository;
    }

    @Override
    protected AdminSpecification getSpecification() {
        return adminSpecification;
    }
}
