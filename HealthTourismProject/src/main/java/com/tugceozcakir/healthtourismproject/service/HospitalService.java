package com.tugceozcakir.healthtourismproject.service;

import com.tugceozcakir.healthtourismproject.database.entity.HospitalEntity;
import com.tugceozcakir.healthtourismproject.database.repository.HospitalRepository;
import com.tugceozcakir.healthtourismproject.database.specification.HospitalSpecification;
import com.tugceozcakir.healthtourismproject.mapper.HospitalMapper;
import com.tugceozcakir.healthtourismproject.model.HospitalDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.HospitalRequestDTO;
import com.tugceozcakir.healthtourismproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService extends BaseService<
        HospitalEntity,
        HospitalDTO,
        HospitalRequestDTO,
        HospitalMapper,
        HospitalRepository,
        HospitalSpecification
        > {

    @Autowired
    HospitalMapper hospitalMapper;

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    HospitalSpecification hospitalSpecification;

    @Override
    protected HospitalMapper getMapper() {
        return hospitalMapper;
    }

    @Override
    protected HospitalRepository getRepository() {
        return hospitalRepository;
    }

    @Override
    protected HospitalSpecification getSpecification() {
        return hospitalSpecification;
    }
}
