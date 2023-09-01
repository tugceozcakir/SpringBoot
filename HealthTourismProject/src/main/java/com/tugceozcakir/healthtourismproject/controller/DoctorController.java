package com.tugceozcakir.healthtourismproject.controller;

import com.tugceozcakir.healthtourismproject.database.entity.DoctorEntity;
import com.tugceozcakir.healthtourismproject.database.repository.DoctorRepository;
import com.tugceozcakir.healthtourismproject.database.specification.DoctorSpecification;
import com.tugceozcakir.healthtourismproject.mapper.DoctorMapper;
import com.tugceozcakir.healthtourismproject.model.AirplaneDTO;
import com.tugceozcakir.healthtourismproject.model.DoctorDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.DoctorRequestDTO;
import com.tugceozcakir.healthtourismproject.service.DoctorService;
import com.tugceozcakir.healthtourismproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController extends BaseController<
        DoctorEntity,
        DoctorDTO,
        DoctorRequestDTO,
        DoctorMapper,
        DoctorRepository,
        DoctorSpecification,
        DoctorService> {

    @Autowired
    DoctorService doctorService;

    @Override
    protected DoctorService getService() {
        return doctorService;
    }

    @GetMapping("select/{id}")
    public ResponseEntity<DoctorDTO> selectDoctor(@PathVariable Long id) {
        return doctorService.selectDoctor(id);
    }
}
