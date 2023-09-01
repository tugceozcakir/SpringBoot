package com.tugceozcakir.healthtourismproject.controller;

import com.tugceozcakir.healthtourismproject.database.entity.AirlineCompanyEntity;
import com.tugceozcakir.healthtourismproject.database.repository.AirlineCompanyRepository;
import com.tugceozcakir.healthtourismproject.database.specification.AirlineCompanySpecification;
import com.tugceozcakir.healthtourismproject.mapper.AirlineCompanyMapper;
import com.tugceozcakir.healthtourismproject.model.AirlineCompanyDTO;
import com.tugceozcakir.healthtourismproject.model.requestDTO.AirlineCompanyRequestDTO;
import com.tugceozcakir.healthtourismproject.service.AirlineCompanyService;
import com.tugceozcakir.healthtourismproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/airline-companies")
public class AirlineCompanyController extends BaseController<
        AirlineCompanyEntity,
        AirlineCompanyDTO,
        AirlineCompanyRequestDTO,
        AirlineCompanyMapper,
        AirlineCompanyRepository,
        AirlineCompanySpecification,
        AirlineCompanyService> {

    @Autowired
    AirlineCompanyService airlineCompanyService;

    @Override
    protected AirlineCompanyService getService() {
        return airlineCompanyService;
    }

    @GetMapping("/select-airline-company/{uuid}")
    public ResponseEntity<AirlineCompanyDTO> selectAirlineCompany(@PathVariable("uuid") UUID uuid) {
        if(airlineCompanyService.selectAirlineCompany(uuid) != null){
            airlineCompanyService.getByUUID(uuid).getAirplaneEntityList();
            return new ResponseEntity(airlineCompanyService.selectAirlineCompany(uuid), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
