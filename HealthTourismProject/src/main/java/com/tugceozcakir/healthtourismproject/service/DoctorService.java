package com.tugceozcakir.healthtourismproject.service;

import com.tugceozcakir.healthtourismproject.database.entity.DoctorEntity;
import com.tugceozcakir.healthtourismproject.database.entity.RoomEntity;
import com.tugceozcakir.healthtourismproject.database.repository.DoctorRepository;
import com.tugceozcakir.healthtourismproject.database.specification.DoctorSpecification;
import com.tugceozcakir.healthtourismproject.mapper.DoctorMapper;
import com.tugceozcakir.healthtourismproject.model.DoctorDTO;
import com.tugceozcakir.healthtourismproject.model.RoomDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.DoctorRequestDTO;
import com.tugceozcakir.healthtourismproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.UUID;

@Service
public class DoctorService extends BaseService<
        DoctorEntity,
        DoctorDTO,
        DoctorRequestDTO,
        DoctorMapper,
        DoctorRepository,
        DoctorSpecification
        > {

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoctorSpecification doctorSpecification;

    @Autowired
    ReservationService reservationService;

    @Override
    protected DoctorMapper getMapper() {
        return doctorMapper;
    }

    @Override
    protected DoctorRepository getRepository() {
        return doctorRepository;
    }

    @Override
    protected DoctorSpecification getSpecification() {
        return doctorSpecification;
    }

    public ResponseEntity<DoctorDTO> selectDoctor(Long id) {
        DoctorEntity entity = getRepository().findById(id).orElse(null);
        if (entity != null) {
            reservationService.makeReservationForDoctor(entity);
            return new ResponseEntity<>(getMapper().entityToDTO(entity), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
