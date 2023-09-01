package com.tugceozcakir.healthtourismproject.controller;

import com.tugceozcakir.healthtourismproject.database.entity.HospitalEntity;
import com.tugceozcakir.healthtourismproject.database.repository.HospitalRepository;
import com.tugceozcakir.healthtourismproject.database.specification.HospitalSpecification;
import com.tugceozcakir.healthtourismproject.mapper.HospitalMapper;
import com.tugceozcakir.healthtourismproject.model.HospitalDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.HospitalRequestDTO;
import com.tugceozcakir.healthtourismproject.service.HospitalService;
import com.tugceozcakir.healthtourismproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospital")
public class HospitalController extends BaseController<
        HospitalEntity,
        HospitalDTO,
        HospitalRequestDTO,
        HospitalMapper,
        HospitalRepository,
        HospitalSpecification,
        HospitalService>{

    @Autowired
    HospitalService hospitalService;

    @Override
    protected HospitalService getService() {
        return hospitalService;
    }
}
