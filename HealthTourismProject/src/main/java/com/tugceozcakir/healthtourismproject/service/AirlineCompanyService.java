package com.tugceozcakir.healthtourismproject.service;

import com.tugceozcakir.healthtourismproject.database.entity.AirlineCompanyEntity;
import com.tugceozcakir.healthtourismproject.database.repository.AirlineCompanyRepository;
import com.tugceozcakir.healthtourismproject.database.specification.AirlineCompanySpecification;
import com.tugceozcakir.healthtourismproject.mapper.AirlineCompanyMapper;
import com.tugceozcakir.healthtourismproject.model.AirlineCompanyDTO;
import com.tugceozcakir.healthtourismproject.model.enums.ReservationStatus;
import com.tugceozcakir.healthtourismproject.model.requestDTO.AirlineCompanyRequestDTO;
import com.tugceozcakir.healthtourismproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.UUID;

@Service
public class AirlineCompanyService extends BaseService<
        AirlineCompanyEntity,
        AirlineCompanyDTO,
        AirlineCompanyRequestDTO,
        AirlineCompanyMapper,
        AirlineCompanyRepository,
        AirlineCompanySpecification
        > {

    @Autowired
    AirlineCompanyMapper airlineCompanyMapper;

    @Autowired
    AirlineCompanyRepository airlineCompanyRepository;

    @Autowired
    AirlineCompanySpecification airlineCompanySpecification;

    @Override
    protected AirlineCompanyMapper getMapper() {
        return airlineCompanyMapper;
    }

    @Override
    protected AirlineCompanyRepository getRepository() {
        return airlineCompanyRepository;
    }

    @Override
    protected AirlineCompanySpecification getSpecification() {
        return airlineCompanySpecification;
    }

    public AirlineCompanyDTO selectAirlineCompany(UUID uuid) {
        AirlineCompanyEntity entity = getRepository().findByUuid(uuid).orElse(null);
        if(entity != null){
            return airlineCompanyMapper.entityToDTO(entity);
        } else {
            return null;
        }
    }
}
